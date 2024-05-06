package com.example.retrofit

import android.content.Intent
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

        val photoPrice = intent.getDoubleExtra("intent_price", 0.0)
        val photoTitle = intent.getStringExtra("intent_title")
        val photoImage = intent.getStringExtra("intent_image")
        val photoCategory = intent.getStringExtra("intent_category")
        val photoDescription = intent.getStringExtra("intent_description")
        val photoCount = intent.getIntExtra("intent_count",0)
        val photoRate = intent.getDoubleExtra("intent_rate", 0.0)

        binding.tvPrice.text = photoPrice.toString()
        Glide.with(this).load(photoImage).override(700, 700).into(binding.tvImage)
        binding.tvTitle.text = photoTitle
        binding.tvCategory.text = photoCategory.toString()
        binding.tvDescription.text = photoDescription.toString()
        binding.tvCount.text = photoCount.toString()
        binding.tvRate.text = photoRate.toString()

    }

    fun onBackClicked(view: View){
        val intent = Intent(this, PhotoActivity::class.java)
        startActivity(intent)
    }
}
