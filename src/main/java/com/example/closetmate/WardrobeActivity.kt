package com.example.closetmate

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.closetmate.util.DBHelper

class WardrobeActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper
    private lateinit var clothingAdapter: ClothingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wardrobe)

        dbHelper = DBHelper(this)

        val clothingItems = dbHelper.getAllClothingItems()

        if (clothingItems.isEmpty()) {
            Toast.makeText(this, "No clothing items found", Toast.LENGTH_SHORT).show()
        } else {
            clothingAdapter = ClothingAdapter(clothingItems)
            val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = clothingAdapter
        }
    }
}
