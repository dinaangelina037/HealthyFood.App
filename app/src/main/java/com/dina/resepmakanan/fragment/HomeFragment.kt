package com.dina.resepmakanan.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.dina.resepmakanan.R
import com.dina.resepmakanan.adapter.AdapterSlider
import com.dina.resepmakanan.adapter.FoodAdapter
import com.dina.resepmakanan.adapter.NamaKategoriAdapter
import com.dina.resepmakanan.model.ApiConfig
import com.dina.resepmakanan.model.ResponseFood
import com.dina.resepmakanan.model.ResponseKategori
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var vpSlider: ViewPager
    lateinit var  rvFood : RecyclerView
    lateinit var rvNamaKategori: RecyclerView
//    lateinit var sRLoading: SwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        val view: View = inflater.inflate(R.layout.home_fragment, container, false)

        vpSlider = view.findViewById(R.id.vp_slider)
        rvFood =view.findViewById(R.id.rv_food)
        rvNamaKategori = view.findViewById(R.id.rv_nama_kategori)
//        sRLoading = view.findViewById(R.id.srl_loading)

        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.breakfast)
        arrSlider.add(R.drawable.lunch1)
        arrSlider.add(R.drawable.dinner3)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpSlider.adapter = adapterSlider

        getNamaKategori()
        getDataRecipe()

        return view

    }

    private fun getDataRecipe() {
        ApiConfig.instanceRetrofit.getRecipe().enqueue(object : Callback<ResponseFood>{
            override fun onResponse(call: Call<ResponseFood>, response: Response<ResponseFood>) {
                if (response.isSuccessful){
                    val responseFood = response.body()
                    val food = responseFood?.data
                    val foodAdapter = FoodAdapter(food)

                    rvFood.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(activity)
                        (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
                        foodAdapter.notifyDataSetChanged()
                        adapter = foodAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseFood>, t: Throwable) {
                Toast.makeText(activity,t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }


    private fun getNamaKategori() {
        ApiConfig.instanceRetrofit.getKategoriRecipe().enqueue(object : Callback<ResponseKategori>{
            override fun onResponse(call: Call<ResponseKategori>, response: Response<ResponseKategori>, ) {
                if (response.isSuccessful){
                    val responseKategori = response.body()
                    val kategori = responseKategori?.data
                    val namaKategoriAdapter = NamaKategoriAdapter(kategori)
                    rvNamaKategori.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(activity)
                        (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
                        namaKategoriAdapter.notifyDataSetChanged()
                        adapter = namaKategoriAdapter

                    }

                }
            }

            override fun onFailure(call: Call<ResponseKategori>, t: Throwable) {
                Toast.makeText(activity,t.localizedMessage, Toast.LENGTH_SHORT).show()

            }

        })

    }
}
