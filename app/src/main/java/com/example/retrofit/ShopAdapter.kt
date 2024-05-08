package com.example.retrofit

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.ItemShopBinding

class ShopAdapter(val listShop: List<Shop>): RecyclerView.Adapter<ShopAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemShopBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemShopBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = listShop.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shop = listShop[position]
        holder.binding.tvPrice.text = ("$ ${shop.price}")
        holder.binding.tvTitle.text = shop.title
        holder.binding.tvCategory.text = shop.category
        Log.d("ShopAdapter", "shopImage: ${shop.image}")
        Glide.with(holder.itemView.context).load(shop.image).override(300,300).optionalCenterCrop().into(holder.binding.imageView)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailActivity::class.java).apply{
                putExtra("intent_price", shop.price)
                putExtra("intent_title", shop.title)
                putExtra("intent_image", shop.image)
                putExtra("intent_category", shop.category)
                putExtra("intent_description", shop.description)
                putExtra("intent_count", shop.rating.count)
                putExtra("intent_rate", shop.rating.rate)
            }
            holder.itemView.context.startActivity(intent)
        }
    }
}