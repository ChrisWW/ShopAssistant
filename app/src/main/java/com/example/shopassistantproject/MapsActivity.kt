package com.example.shopassistantproject

import android.Manifest
import android.app.PendingIntent
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingRequest
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val geoClient = LocationServices.getGeofencingClient(this)
        var id = 0

        bt_place.setOnClickListener {val perms = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            {
                requestPermissions(perms, 0)
            }
            LocationServices.getFusedLocationProviderClient(this).lastLocation
                .addOnSuccessListener {
                    Log.i("location", "Location: ${it.latitude}, ${it.longitude}")
                    val latlng = LatLng(it.latitude, it.longitude)

                    val marker = MarkerOptions()
                        .position(latlng)
                        .title(et_place.text.toString())
                    mMap.addMarker(marker)
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng))
//

                    val radius = et_radius.text.toString()
                    val geo = Geofence.Builder()
                            .setRequestId("Geo${id++}")
                            .setCircularRegion(it.latitude, it.longitude, radius.toFloat())
                            .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER or Geofence.GEOFENCE_TRANSITION_EXIT)
                            .setExpirationDuration(Geofence.NEVER_EXPIRE)
                            .build()


                    val geoRequest = GeofencingRequest.Builder()
                            .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER)
                            .addGeofence(geo)
                            .build()

                    val geoPendingIntent = PendingIntent.getBroadcast(
                            this,
                            id,
                            Intent(this, GeoReceiver::class.java),
                            PendingIntent.FLAG_UPDATE_CURRENT
                    )



                    val viewModelMaps = MapsViewModel(application)
                    viewModelMaps.add(

                            //id = viewModelMaps.getItemCount()
                            Maps(id = id.toLong(),
                                    name = et_place.text.toString(),
                                    description = et_description.text.toString(),
                                    radius = radius.toString(),
                                    latitude = it.latitude,
                                    longitude = it.longitude

                            )
                    )


                    geoClient.addGeofences(geoRequest, geoPendingIntent)


                }
            val broadcast = Intent()
            broadcast.action = getString(R.string.addMaps)
            broadcast.component = ComponentName(this, GeoReceiver::class.java)
            broadcast.putExtra("shop", et_place.text.toString())
            broadcast.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
            sendBroadcast(broadcast)

        }
    }

    override fun onMapReady(googleMap: GoogleMap) {

        // Otrzymac polozenie gdzie sie znajdujemy
        mMap = googleMap
        val perms = arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        )
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(perms, 0)
        }
        mMap.isMyLocationEnabled = true
        // Add a marker in Sydney and move the camera
       /* val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))*/
    }


}