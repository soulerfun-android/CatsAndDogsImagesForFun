package com.example.lelele.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImageListDao {

    @Query("SELECT * FROM image_items")
    fun getImageList(): LiveData<List<ImageItemDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addShopItem(imageItemDbModel: ImageItemDbModel)

    @Query("DELETE FROM image_items WHERE id=:imageItemId")
    fun deleteShopItem(imageItemId: Int)
}