package com.example.shopassistantproject

import androidx.lifecycle.LiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/*class FirebaseDatabaseLiveData : LiveData<List<Shopping>>() {
    override fun onActive() {
        super.onActive()

        FirebaseDatabase.getInstance()
            .getReference("feed/articles")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        // value = toShopping(snapshot)
                    })
                }
            } */