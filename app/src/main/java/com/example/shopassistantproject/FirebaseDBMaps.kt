package com.example.shopassistantproject

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_maps.*
public lateinit var mMap: GoogleMap
class FirebaseDBMaps : LiveData<List<Maps>>() {

    public var fbItemCountMaps:Long = 0
    private val firebaseDB2: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val userID = FirebaseAuth.getInstance().uid
    public val refMap = firebaseDB2.getReference("user/"+userID+"/shops/".toString())
    fun removeAll() {
        refMap.removeValue()
    }

    fun delete(maps: Maps){
        refMap.child(maps.id.toString()).removeValue()
    }

    fun add(maps: Maps) {
        Log.v("Async101", "Start loading add bookmarks")
        refMap.child(maps.id.toString()).setValue(maps)
    }

    fun getMaps(callbackmaps: CallbackMaps) {
        //lateinit var mMap2: GoogleMap
        Log.v("Async101", "Start loading bookmarks")
        refMap.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val lista: MutableList<Maps> = mutableListOf()

                Log.v("Async101", "Done loading bookmarks");
                for (messageSnapshot in dataSnapshot.children) {
                    val maps: Maps = Maps(id = messageSnapshot.child("id").value as Long,
                            name = messageSnapshot.child("name").value as String,
                            description = messageSnapshot.child("description").value as String,
                            radius =  messageSnapshot.child("radius").value as String,
                            latitude = messageSnapshot.child("latitude").value as Double,
                            longitude = messageSnapshot.child("longitude").value as Double,
                    )

                    lista.add(maps)
                    val marker = MarkerOptions()
                            .position(LatLng(maps.latitude, maps.longitude))
                            .title(maps.name.toString())
                    mMap.addMarker(marker)
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(maps.latitude, maps.longitude)))

                }
                callbackmaps.getListaMaps(lista)
                fbItemCountMaps = lista.size.toLong()
                var id = 0
                id = dataSnapshot.children.count()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("MyAdapter", "Failed to delete value.",error.toException())
            }

        })
        Log.v("Async101", "Returning loaded bookmarks");
    }

}


interface CallbackMaps {
    fun getListaMaps(mapsList: List<Maps>)
}
