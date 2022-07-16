package com.dina.resepmakanan.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dina.resepmakanan.R
import com.dina.resepmakanan.acitivity.DetailActivity
import com.dina.resepmakanan.acitivity.PerkategoriActivity
import com.dina.resepmakanan.model.DataItem
import com.squareup.picasso.Picasso

class FoodAdapter(var listFood: List<DataItem?>?) : RecyclerView.Adapter<FoodAdapter.MyViewHolder>(){

    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        val imgFood = itemview.findViewById<ImageView>(R.id.img_food)
        val tvNameFood = itemview.findViewById<TextView>(R.id.tv_name_food)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_food, parent,false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvNameFood.text = listFood?.get(position)?.name

        val img = "http://192.168.137.139/healthy-app/public/storage/"+listFood?.get(position)?.image

        Picasso.get()
            .load(img)
            .placeholder(R.drawable.breakfast)
            .error(R.drawable.ic_home)
            .into(holder.imgFood)

        val context = holder.itemView.context
        holder.itemView.setOnClickListener {
            val i = Intent(context, DetailActivity::class.java)
            i.putExtra("RECIPE", listFood?.get(position))
            context.startActivity(i)
        }
    }
    override fun getItemCount(): Int {
        if (listFood != null){
            return listFood!!.size
        }else{
            return 0
        }
    }
}

