package com.example.closetmate.util

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.closetmate.model.ClothingItem

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "closetmate.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Create table query
        val createTableQuery = """
            CREATE TABLE clothing_items (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                type TEXT,
                color TEXT,
                image_res INTEGER
            )
        """
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Drop older table if exists and create a new one
        db.execSQL("DROP TABLE IF EXISTS clothing_items")
        onCreate(db)
    }

    // Add clothing item to the database
    fun addClothingItem(name: String, type: String, color: String, imageRes: Int) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("name", name)
            put("type", type)
            put("color", color)
            put("image_res", imageRes)
        }
        db.insert("clothing_items", null, values)
        db.close()
    }

    // Get all clothing items from the database
    fun getAllClothingItems(): List<ClothingItem> {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM clothing_items", null)
        val clothingItems = mutableListOf<ClothingItem>()

        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow("id"))
                val name = getString(getColumnIndexOrThrow("name"))
                val type = getString(getColumnIndexOrThrow("type"))
                val color = getString(getColumnIndexOrThrow("color"))
                val imageRes = getInt(getColumnIndexOrThrow("image_res"))

                clothingItems.add(ClothingItem(id, name, type, color, imageRes))
            }
        }

        cursor.close()
        db.close()
        return clothingItems
    }
}
