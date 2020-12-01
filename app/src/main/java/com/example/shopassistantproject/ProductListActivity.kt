package com.example.shopassistantproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shopassistantproject.databinding.ActivityProductListBinding

class ProductListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}