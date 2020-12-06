package com.example.shopassistantproject

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDao {

    @Query("SELECT * FROM shopping")
    fun getShopping(): LiveData<List<Shopping>>

    @Insert
    fun add(shopping: Shopping)

    @Update
    fun modify(shopping: Shopping)

    @Delete
    fun delete(shopping: Shopping)

    @Query("DELETE FROM shopping")
    fun removeAll()
    
}