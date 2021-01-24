package com.example.shopassistantproject

import com.google.android.gms.maps.model.LatLng

data class Maps(
        var id: Long = 0,
        var name: String,
        var description: String,
        var radius: String,
        var latitude: Double,
        var longitude: Double
)