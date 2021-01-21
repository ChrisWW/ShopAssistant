package com.example.shopassistantproject

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

/*
class MapsReceiver : BroadcastReceiver() {

    private var id = 0
    override fun onReceive(context: Context, intent: Intent) {
        if(intent.action == context.getString(R.string.addMaps)){
            createChannel(context)

            val lista = Intent(context, MapsActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(
                    context,
                    id,
                    lista,
                    PendingIntent.FLAG_ONE_SHOT

            )

            val notification = NotificationCompat.Builder(context, context.getString(R.string.channelID))
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentTitle("Enter to a shop:")
                    .setContentText(intent.getStringExtra("name"))
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .build()

            NotificationManagerCompat.from(context).notify(id++, notification)

        }
    }

    fun createChannel(context: Context){

        val channel = NotificationChannel(
                context.getString(R.string.channelID),
                context.getString(R.string.channelName),
                NotificationManager.IMPORTANCE_DEFAULT

        )

        NotificationManagerCompat.from(context).createNotificationChannel(channel)

    }
}
*/