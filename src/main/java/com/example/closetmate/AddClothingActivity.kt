package com.example.closetmate

import ClothingItem
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.closetmate.databinding.ActivityAddClothingBinding

class AddClothingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddClothingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddClothingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val type = binding.editType.text.toString()
            val color = binding.editColor.text.toString()

            if (type.isNotEmpty() && color.isNotEmpty()) {
                val item = ClothingItem(type, color, "M", "Blue", "")
                ClothingData.items.add(item)
                Toast.makeText(this, "Clothing added!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
