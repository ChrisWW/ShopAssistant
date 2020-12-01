package com.example.shopassistantproject

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopassistantproject.databinding.ActivityProductListBinding
import kotlinx.android.synthetic.main.activity_product_list.view.*

class ProductListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ShoppingViewModel(application)
        val adapter = MyAdapter(viewModel)

        // If some changes in DB, it will go for method seyShoppingList in Adapter and change data in DB
        viewModel.allShopping.observe(this, Observer {
            it.let {
                adapter.setShoppingList(it)
            }
        })

        //Layout Manager
        binding.rvl1.layoutManager = LinearLayoutManager(this)

        //DivideItemDecorator(not merging)
        binding.rvl1.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        //Adapter
        binding.rvl1.adapter = adapter

        // rewrite names of arguments, adding to DB
        binding.btl1.setOnClickListener {
            viewModel.add(Shopping(
                    product = binding.edl1.text.toString(),
                    quantity = binding.edl2.text.toString(),
                    bought = binding.ch1.isChecked
                )
            )
        }


        binding.btl1.setOnLongClickListener {

            viewModel.removeAll()
            true

        }

    }
}
