package com.example.retrofit

import android.os.Bundle
import android.util.Log
import android.view.View
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

        showLoading(true)

        RetrofitClient.instance.getShops().enqueue(object : Callback<List<Shop>> {
            override fun onResponse(
                call: Call<List<Shop>>,
                response: Response<List<Shop>>
            ) {
                showLoading(false)
                if (response.isSuccessful) {
                    setAdapter(response.body())
                } else {
                    Log.e("ShopActivity", "Failed to get shop: ${response.message()}")
                    Toast.makeText(
                        this@ShopActivity,
                        "Failed to get shop: ${response.message()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Shop>>, t: Throwable) {
                showLoading(false)
                Log.e("ShopActivity", "Failed to get shop: ${t.message}")
                Toast.makeText(
                    this@ShopActivity,
                    "Failed to get shop: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })

    }

    private fun setAdapter(shop: List<Shop>?) {
        binding.rvShop.adapter = ShopAdapter(shop ?: listOf())
    }

    private fun showLoading(loading: Boolean) {
        when (loading) {
            true -> binding.progressBar.visibility = View.VISIBLE
            false -> binding.progressBar.visibility = View.GONE
        }
    }

}