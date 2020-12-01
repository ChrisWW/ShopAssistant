package com.example.shopassistantproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ShoppingViewModel(application: Application) : AndroidViewModel(application){

    private val repo: ShoppingRepo
    val allShopping: LiveData<List<Shopping>>

    init {
        repo = ShoppingRepo(ShoppingDB.getDatabase(application.applicationContext).getShoppingDao())
        allShopping = repo.getShopping()
    }

    fun add(shopping: Shopping) = repo.add(shopping)

    fun modify(shopping: Shopping) = repo.modify(shopping)

    fun remove(shopping: Shopping) = repo.delete(shopping)

    fun removeAll() = repo.removeAll()
}
