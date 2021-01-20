package com.example.shopassistantproject

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MapsViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: MapsRepo
    val allMaps: MutableLiveData<List<Maps>> = MutableLiveData()


    init {
        repo = MapsRepo(FirebaseDBMaps())
        repo.getMaps(object: CallBackRepoMaps {
            override fun getMapsCall(mapsList: List<Maps>) {
                Log.d("TEST", "shoppinglist:"+mapsList)
                allMaps.value = mapsList
            }
        } )
    }


    fun add(maps: Maps) = repo.add(maps)

    fun remove(maps: Maps) = repo.delete(maps)

    fun removeAll() = repo.removeAll()

    //fun getShopping() = repo.getShopping()

    fun getItemCount() = repo.getItemCount()
}