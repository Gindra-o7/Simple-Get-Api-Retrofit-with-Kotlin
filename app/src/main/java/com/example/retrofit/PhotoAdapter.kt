package com.example.retrofit

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.databinding.ItemPhotoBinding

class PhotoAdapter(val listPhoto: List<Photo>): RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemPhotoBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = listPhoto.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = listPhoto[position]
        holder.binding.tvId.text = photo.id.toString()
        holder.binding.tvTitle.text = photo.title

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailActivity::class.java).apply{
                putExtra("intent_id", photo.id)
                putExtra("intent_title", photo.title)
                putExtra("intent_albumId", photo.albumId)
                putExtra("intent_url", photo.url)
                putExtra("intent_thumbnailUrl", photo.thumbnailUrl)
            }
            holder.itemView.context.startActivity(intent)
        }
    }
}