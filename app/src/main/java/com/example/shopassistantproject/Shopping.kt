package com.example.shopassistantproject

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Shopping(
    @PrimaryKey(autoGenerate = true)
    var product: Long,
    var quantity: String,
    var bought: Boolean)