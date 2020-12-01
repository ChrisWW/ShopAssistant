package com.example.shopassistantproject

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopassistantproject.databinding.ActivityProductListBinding

class ProductListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val elementList = arrayListOf("Element 1", "Element 2", "Element 3")

        //Layout Manager
        binding.rvl1.layoutManager = LinearLayoutManager(this)

        //DivideItemDecorator(not merging)
        binding.rvl1.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        //Adapter
        binding.rvl1.adapter = MyAdapter(elementList)




        }

    }
