package com.example.shopassistantproject

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ShoppingViewModel(application: Application) : AndroidViewModel(application){

    private val repo: ShoppingRepo
    private val firebaseDB: FirebaseDB = FirebaseDB()

    // Dlaczego bez LiveData
    val allShopping: MutableLiveData<List<Shopping>> = MutableLiveData()

    init {
        repo = ShoppingRepo(FirebaseDB())
        //allShopping.value = repo.getShopping() //as List<Shopping>
        repo.getShopping(object: CallBackRepo {
            override fun getShopCall(shoppingList: List<Shopping>) {
                Log.d("TEST", "shoppinglist:"+shoppingList)
                allShopping.value = shoppingList
            }
        } )
    }


    fun add(shopping: Shopping) = repo.add(shopping)

    fun modify(shopping: Shopping) = repo.modify(shopping)

    fun remove(shopping: Shopping) = repo.delete(shopping)

    fun removeAll() = repo.removeAll()

    //fun getShopping() = repo.getShopping()

    fun getItemCount() = repo.getItemCount()
}


