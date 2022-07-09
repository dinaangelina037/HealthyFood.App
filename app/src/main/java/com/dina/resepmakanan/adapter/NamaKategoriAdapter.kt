package com.dina.resepmakanan.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.dina.resepmakanan.R
import com.dina.resepmakanan.acitivity.PerkategoriActivity
import com.dina.resepmakanan.model.Kategori

class NamaKategoriAdapter (var listNamaKategori: List<Kategori?>?) : RecyclerView.Adapter<NamaKategoriAdapter.MyViewHolder>(){

    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNamaKategori = itemView.findViewById<TextView>(R.id.tv_nama_kategori)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ):MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_kategori,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        holder.tvNamaKategori.text = listNamaKategori?.get(position)?.nameCategory

        val context = holder.itemView.context
        holder.itemView.setOnClickListener {
//            Toast.makeText(context,listNamaKategori?.get(position)?.categori, Toast.LENGTH_SHORT).show()

            val i = Intent(context, PerkategoriActivity::class.java)
            i.putExtra("DTL", listNamaKategori?.get(position))
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return listNamaKategori!!.size
    }

}


