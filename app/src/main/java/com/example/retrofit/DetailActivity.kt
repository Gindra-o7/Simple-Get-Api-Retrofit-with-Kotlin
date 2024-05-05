package com.example.retrofit

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val photoId = intent.getIntExtra("intent_id", 0)
        val photoTitle = intent.getStringExtra("intent_title")
        val photoAlbumId = intent.getIntExtra("intent_albumId", 0)
        val photoUrl = intent.getStringExtra("intent_url")
        val photothumbnailUrl = intent.getStringExtra("intent_thumbnailUrl")

        binding.tvId.text = ("Id : $photoId")
        binding.tvAlbumid.text = ("Id Album : $photoAlbumId")
        binding.tvTitle.text = ("Judul : $photoTitle")
        binding.tvUrl.text = ("Url : $photoUrl")
        binding.tvThumbnailUrl.text = ("Thumbnail Url : $photothumbnailUrl")
    }
}
