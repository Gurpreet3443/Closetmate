package com.example.closetmate

import ClothingItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.closetmate.R.drawable.jeans
import com.example.closetmate.databinding.ItemClothingBinding

class ClothingAdapter(private val clothingList: List<ClothingItem>) :
    RecyclerView.Adapter<ClothingAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val clothingImage: ImageView = itemView.findViewById(R.id.clothingImage)
        val clothingType: TextView = itemView.findViewById(R.id.clothingType)
        val clothingColor: TextView = itemView.findViewById(R.id.clothingColor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_clothing, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = clothingList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = clothingList[position]
        holder.clothingType.text = item.type
        holder.clothingColor.text = "Color: ${item.color}"

        val imageRes = when (item.type.lowercase()) {
            "shirt" -> R.drawable.shirt
            "pant" -> R.drawable.jeans
            "dress" -> R.drawable.dress
            else -> R.drawable.default_clothing
        }

        holder.clothingImage.setImageResource(imageRes) //
    }}// ✅ Returns Unit, no assignment needed


