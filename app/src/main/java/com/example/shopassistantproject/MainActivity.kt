package com.example.shopassistantproject

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.shopassistantproject.databinding.ActivityMainBinding
import com.example.shopassistantproject.databinding.ActivityOptionsBinding
import com.example.shopassistantproject.databinding.ActivityProductListBinding
import kotlinx.android.synthetic.main.activity_options.*


class MainActivity : AppCompatActivity() {




    private lateinit var binding: ActivityMainBinding
    private lateinit var sp: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = getSharedPreferences("shared", MODE_PRIVATE)

        binding.bt1.setOnClickListener {
            val intent1 = Intent(this, OptionsActivity::class.java)
            startActivity(intent1)
        }
        binding.bt2.setOnClickListener {
            val intent2 = Intent(this, ProductListActivity::class.java)
            startActivity(intent2)
        }
    }
//

    override fun onStart() {
        super.onStart()
        val binding2 = ActivityOptionsBinding.inflate(layoutInflater)
        val bindingP = ActivityProductListBinding.inflate(layoutInflater)
        val editor = sp.edit()


        if (sp.getBoolean("dark", true)) {
            AppCompatDelegate.setDefaultNightMode(2.toInt())
        }

        else {
            AppCompatDelegate.setDefaultNightMode(1.toInt())

        }

        if (sp.getBoolean("big", true)) {

            binding2.txo1.textSize = bigdata.toFloat()
            binding2.txo2.textSize = bigdata.toFloat()
            binding2.s1.textSize = bigdata.toFloat()
            binding2.s2.textSize = bigdata.toFloat()

        }
        else {


            binding2.txo1.textSize = smalldata.toFloat()
            binding2.txo2.textSize = smalldata.toFloat()
            binding2.s1.textSize = smalldata.toFloat()
            binding2.s2.textSize = smalldata.toFloat()

        }


    }



}