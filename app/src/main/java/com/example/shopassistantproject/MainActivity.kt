package com.example.shopassistantproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shopassistantproject.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = getPreferences(Context.MODE_PRIVATE)

        binding.bt1.setOnClickListener {
            val intent1 = Intent(this, OptionsActivity::class.java)
            startActivity(intent1)
        }
        binding.bt2.setOnClickListener {
            val intent2 = Intent(this, ProductListActivity::class.java)
            startActivity(intent2)
        }



    }
}