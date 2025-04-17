package com.example.closetmate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.closetmate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddClothing.setOnClickListener {
            startActivity(Intent(this, AddClothingActivity::class.java))
        }

        binding.btnViewWardrobe.setOnClickListener {
            startActivity(Intent(this, WardrobeActivity::class.java))
        }
    }
}
