package com.dina.resepmakanan.acitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dina.resepmakanan.R
import com.dina.resepmakanan.databinding.ActivityDetailBinding
import com.dina.resepmakanan.model.DataItem
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_perkategori.*
import kotlinx.android.synthetic.main.item_row_food.*

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }

        detailRecipe()


    }

    private fun detailRecipe() {
        val dataDetailRecipe = intent.getParcelableExtra<DataItem>("RECIPE")

        if (dataDetailRecipe != null){
//            Glide.with(this)
//                .load(dataDetailRecipe?.id)
//                .into(binding.ivDetail)


            binding.tvTitle.text = dataDetailRecipe.name
            binding.tvSubTitle.text = dataDetailRecipe.slug
            binding.tvDescIngredients.text = dataDetailRecipe.ingredient
            binding.tvDescCalories.text = dataDetailRecipe.calories
            binding.tvDescInstructions.text = dataDetailRecipe.step
            binding.tvDesc.text =dataDetailRecipe.description

        }

    }
}