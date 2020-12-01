package com.example.shopassistantproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shopassistantproject.databinding.ActivityOptionsBinding

class OptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //What exactly layoutinflater makes?
        val binding = ActivityOptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent1 = intent
    }
}