package com.example.retrofit

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit.databinding.ActivityShopBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ShopActivity : AppCompatActivity() {

    private val binding by lazy { ActivityShopBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        RetrofitClient.instance.getShops().enqueue(object : Callback<List<Shop>>{
            override fun onResponse(
                call: Call<List<Shop>>,
                response: Response<List<Shop>>
            ) {
                setAdapter(response.body())
            }

            override fun onFailure(call: Call<List<Shop>>, t: Throwable) {
                Log.e("ShopActivity", "Failed to get shop: ${t.message}")
                Toast.makeText(this@ShopActivity, "Failed to get shop: ${t.message}", Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun setAdapter(shop: List<Shop>?) {
        binding.rvShop.adapter = ShopAdapter(shop ?: listOf())
    }

}