package com.dina.resepmakanan.acitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.dina.resepmakanan.R
import com.dina.resepmakanan.databinding.ActivityDetailBinding
import com.dina.resepmakanan.model.DataItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_perkategori.*
import kotlinx.android.synthetic.main.item_row_food.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Boolean.TRUE

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
//    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

            setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        detailRecipe()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun detailRecipe() {
        val dataDetailRecipe = intent.getParcelableExtra<DataItem>("RECIPE")
        if (dataDetailRecipe != null){

            val img = "http://192.168.33.102/healthy-app/public/storage/"+dataDetailRecipe.image

            Picasso.get()
                .load(img)
                .placeholder(R.drawable.breakfast)
                .error(R.drawable.ic_home)
                .into(binding.imgThumb)

            binding.tvTitle.text = dataDetailRecipe.name
            binding.tvSubTitle.text = dataDetailRecipe.slug
            binding.tvDescIngredients.text = dataDetailRecipe.ingredient
            binding.tvDescCalories.text = dataDetailRecipe.calories
            binding.tvDescInstructions.text = dataDetailRecipe.step
            binding.tvDesc.text =dataDetailRecipe.description

        }
    }
}
