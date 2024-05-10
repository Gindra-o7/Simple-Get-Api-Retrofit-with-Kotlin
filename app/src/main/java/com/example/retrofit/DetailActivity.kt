package com.example.retrofit

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val shopPrice = intent.getDoubleExtra("intent_price", 0.0)
        val shopTitle = intent.getStringExtra("intent_title")
        val shopImage = intent.getStringExtra("intent_image")
        val shopCategory = intent.getStringExtra("intent_category")
        val shopDescription = intent.getStringExtra("intent_description")
        val shopCount = intent.getIntExtra("intent_count",0)
        val shopRate = intent.getDoubleExtra("intent_rate", 0.0)

        binding.tvPrice.text = ("$ $shopPrice")
        Glide.with(this).load(shopImage).override(700, 700).into(binding.tvImage)
        binding.tvTitle.text = shopTitle
        binding.tvCategory.text = shopCategory.toString()
        binding.tvDescription.text = shopDescription.toString()
        binding.tvCount.text = shopCount.toString()
        binding.tvRate.text = shopRate.toString()

    }

    fun onBackClicked(view: View){
        finish()
    }
}
