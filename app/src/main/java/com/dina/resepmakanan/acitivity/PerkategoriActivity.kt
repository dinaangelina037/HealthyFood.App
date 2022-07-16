package com.dina.resepmakanan.acitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.dina.resepmakanan.R
import com.dina.resepmakanan.adapter.FoodAdapter
import com.dina.resepmakanan.model.*
import com.dina.resepmakanan.model.remote.response.Kategori
import com.dina.resepmakanan.model.remote.retrofit.ApiConfig
import kotlinx.android.synthetic.main.activity_perkategori.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PerkategoriActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perkategori)

        kategori()
        refresh()

    }
    private fun refresh() {
        refresh.setOnRefreshListener{
            kategori()
            refresh.isRefreshing = false
        }
    }
    private fun kategori() {
        val dataKategori = intent.getParcelableExtra<Kategori>("DTL")
        if (dataKategori !=null){
            val kategori_id = dataKategori?.id
            tv_kategori_food.text = dataKategori.nameCategory
            getPerkategori(kategori_id)

        }
    }
    private fun getPerkategori(categori: Int?) {
        pb_per_kategori.visibility = View.VISIBLE
       if (categori != null) {
          ApiConfig.instanceRetrofit.getPerkategori(categori).enqueue(object : Callback<ResponseFood>{
              override fun onResponse(call: Call<ResponseFood>, response: Response<ResponseFood>) {
                  pb_per_kategori.visibility = View.GONE
                  if (response.isSuccessful){
                      val responseFood = response.body()
                      val kategori = responseFood?.data
                      val foodAdapter = FoodAdapter(kategori)

                      rv_per_kategori.apply {
                          layoutManager = GridLayoutManager(this@PerkategoriActivity,2)
                          setHasFixedSize(true)
                          adapter = foodAdapter
                      }
                  }
              }
              override fun onFailure(call: Call<ResponseFood>, t: Throwable) {
                  Toast.makeText(this@PerkategoriActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
              }
          })
       }
    }
}