package com.example.retrofit

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retrofit.databinding.ActivityPhotoBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PhotoActivity : AppCompatActivity() {

    private val binding by lazy { ActivityPhotoBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        RetrofitClient.instance.getPhotos().enqueue(object : Callback<List<Photo>>{
            override fun onResponse(
                call: Call<List<Photo>>,
                response: Response<List<Photo>>
            ) {
                val code = response.code().toString()
                if (code.equals("200")) {
                    setAdapter(response.body())
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Log.e("PhotoActivity", "Failed to get photos: ${t.message}")
                Toast.makeText(this@PhotoActivity, "Failed to get photos: ${t.message}", Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun setAdapter(photo: List<Photo>?) {
        binding.rvPhoto.adapter = PhotoAdapter(photo ?: listOf())
    }

}