package com.example.closetmate

import ClothingItem

class FirebaseRepository {

    fun addClothingItem(clothingItem:ClothingItem) {
        // Code to save clothing item in Firebase Firestore
        // Firestore example:
        // val db = FirebaseFirestore.getInstance()
        // db.collection("wardrobe").add(clothingItem)
    }

    fun getClothingItems():List<ClothingItem>

    {
        // Code to fetch clothing items from Firebase Firestore
        return listOf(
                ClothingItem("Blue Shirt", "Shirt", "M", "Blue", ""),
                ClothingItem("Black Jeans", "Pants", "L", "Black", "")
        )
    }
}
