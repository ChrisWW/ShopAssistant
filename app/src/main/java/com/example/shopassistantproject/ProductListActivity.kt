package com.example.shopassistantproject

import android.content.ComponentName
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopassistantproject.databinding.ActivityMainBinding
import com.example.shopassistantproject.databinding.ActivityOptionsBinding
import com.example.shopassistantproject.databinding.ActivityProductListBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_options.*
import kotlinx.android.synthetic.main.activity_product_list.*
import kotlinx.android.synthetic.main.activity_product_list.view.*
import kotlinx.android.synthetic.main.list_element.*

class ProductListActivity : AppCompatActivity() {

    private lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ShoppingViewModel(application)
        val adapter = MyAdapter(viewModel)

       // val liveData: LiveData<List<Shopping>>
         //liveData = MutableLiveData()

        //Layout Manager
        binding.rvl1.layoutManager = LinearLayoutManager(this)

        //DivideItemDecorator(not merging)
        binding.rvl1.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        //Adapter
        binding.rvl1.adapter = adapter


        // If some changes in DB, it will go for method setShoppingList in Adapter and change data in DB
        viewModel.allShopping.observe(this, Observer {
            it.let {
                adapter.setShoppingList(it)
            }
        })
        //liveData.value = viewModel.allShopping




        //

       // val database = FirebaseDB()
        //val ref = database.ref

        val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
        val userID = FirebaseAuth.getInstance().uid
        val datebase = FirebaseDB()
        //val ref = firebaseDatabase.getReference(userID.toString())
        val ref = datebase.ref

        // Toast.makeText(this, viewModel.allShopping[0]?.toString(), Toast.LENGTH_SHORT).show()
        // rewrite names of arguments, adding to DB

        // viewmodel.add
        binding.btl1.setOnClickListener {
            viewModel.add(
                Shopping(id = viewModel.getItemCount(),
                    product = binding.edl1.text.toString(),
                    quantity = binding.edl2.text.toString(),
                    price = binding.edl3.text.toString(),
                    bought = binding.ch1.isChecked,

                    )
            )


            /* val broadcast = Intent()
            broadcast.action = getString(R.string.addProduct)
            // broadcast.component = ComponentName("com.example.projekt2", "com.example.projekt2.MainActivity")
            // w przypadku drugiej aplikacji aby sie odnieść należy zrobić to tak
            broadcast.component = ComponentName(this, ProductReceiver::class.java)
            broadcast.putExtra("Productname", edl1.text.toString())
            broadcast.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
            sendBroadcast(broadcast)
        }
            */

            binding.btl2.setOnClickListener {
                viewModel.modify(
                    Shopping(
                        id = adapter.POZYCJA.toLong(),
                        product = binding.edl1.text.toString(),
                        quantity = binding.edl2.text.toString(),
                        price = binding.edl3.text.toString(),
                        bought = binding.ch1.isChecked,
                    )
                )

                val toast = Toast.makeText(this, adapter.POZYCJA.toString(), Toast.LENGTH_SHORT)
                toast.show()
            }

            binding.btl1.setOnLongClickListener {

                viewModel.removeAll()
                true

            }

        }


    }
}
