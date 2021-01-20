package com.example.shopassistantproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopassistantproject.databinding.ActivityProductListBinding
import com.example.shopassistantproject.databinding.ActivityShopsListBinding
import java.util.Observer

class ShopsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityShopsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModelMaps = MapsViewModel(application)
        val adapter = MyAdapterMaps(viewModelMaps)


    //Layout Manager
    binding.rvlm1.layoutManager = LinearLayoutManager(this)

    //DivideItemDecorator(not merging)
    binding.rvlm1.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

    //Adapter
    binding.rvlm1.adapter = adapter


    // If some changes in DB, it will go for method setShoppingList in Adapter and change data in DB

        viewModelMaps.allMaps.observe(this, androidx.lifecycle.Observer {
            it.let {
                adapter.setMapsList(it)
            }
        })
}
}