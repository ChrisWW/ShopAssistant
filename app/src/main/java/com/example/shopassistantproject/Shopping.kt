package com.example.shopassistantproject

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Shopping(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var product: String,
    var quantity: String,
    var bought: Boolean)