package com.example.retrofit

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.ItemPhotoBinding

class PhotoAdapter(val listPhoto: List<Photo>): RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemPhotoBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = listPhoto.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = listPhoto[position]
        holder.binding.tvPrice.text = photo.price.toString()
        holder.binding.tvTitle.text = photo.title
        holder.binding.tvCategory.text = photo.category
        Log.d("PhotoAdapter", "photoImage: ${photo.image}")
        Glide.with(holder.itemView.context).load(photo.image).override(300,300).optionalCenterCrop().into(holder.binding.imageView)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailActivity::class.java).apply{
                putExtra("intent_price", photo.price)
                putExtra("intent_title", photo.title)
                putExtra("intent_image", photo.image)
                putExtra("intent_category", photo.category)
                putExtra("intent_description", photo.description)
                putExtra("intent_count", photo.rating.count)
                putExtra("intent_rate", photo.rating.rate)
            }
            holder.itemView.context.startActivity(intent)
        }
    }
}