package com.example.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
                TODO("Not yet implemented")
            }

        })

    }

    private fun setAdapter(photo: List<Photo>?) {
        binding.rvPhoto.adapter = PhotoAdapter(photo ?: listOf())
    }

}