package com.example.shopassistantproject

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.properties.Delegates

class FirebaseDB : LiveData<List<Shopping>>() {

    public var fbItemCount:Long = 0
    private val firebaseDB2: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val userID = FirebaseAuth.getInstance().uid
    public val ref = firebaseDB2.getReference("user/"+userID+"/products/".toString())

    //val ordersRef = ref.child("orders").orderByChild("phonenumber").equalTo(product)

    /*lateinit var product: String
   lateinit var quantity: String
    lateinit var price: String
    var isbought by Delegates.notNull<Boolean>() */


    fun removeAll() {
        ref.removeValue()
    }

    fun delete(shopping: Shopping){
        ref.child(shopping.id.toString()).removeValue()
    }

    fun modify(shopping: Shopping) {
        ref.child(shopping.id.toString()).setValue(shopping)
    }

    fun add(shopping: Shopping) {
        Log.v("Async101", "Start loading add bookmarks")
        ref.child(shopping.id.toString()).setValue(shopping)
    }

    fun getShopping(callback: Callback) {

        Log.v("Async101", "Start loading bookmarks")
        ref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val lista: MutableList<Shopping> = mutableListOf()

                Log.v("Async101", "Done loading bookmarks");
                for (messageSnapshot in dataSnapshot.children) {
                    val shopping: Shopping = Shopping(id = messageSnapshot.child("id").value as Long,
                            product = messageSnapshot.child("product").value as String,
                            quantity = messageSnapshot.child("quantity").value as String,
                            price = messageSnapshot.child("price").value as String,
                            bought = messageSnapshot.child("bought").value as Boolean)

                    //Log.i("readDB", "$product $quantity $price $isbought")

                    lista.add(shopping)
                }
                //data.postValue(lista)
                callback.getLista(lista)
                fbItemCount = lista.size.toLong()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("MyAdapter", "Failed to delete value.",error.toException())
            }

        })

        Log.v("Async101", "Returning loaded bookmarks");
        //ordersRef.addListenerForSingleValueEvent(valueEventListener)




        //return lista
    }

}


interface Callback {
    fun getLista(shoppingList: List<Shopping>)
}