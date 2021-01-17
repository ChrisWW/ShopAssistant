package com.example.shopassistantproject

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.google.android.gms.location.GeofencingEvent

class GeoReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val event = GeofencingEvent.fromIntent(intent)
        for( geo in event.triggeringGeofences) {
            Toast.makeText(context, "Geofence with id: ${geo.requestId} triggered.", Toast.LENGTH_SHORT).show()
        }
    }
}