package com.evapharma.medicinereminder.features.auth.data.remote

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.evapharma.medicinereminder.MainActivity
import com.evapharma.medicinereminder.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val TAG = "MyFirebaseMsgService"

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        // Handle FCM messages here.
        remoteMessage.notification?.let {
            sendNotification(it.body)
        }
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // Handle the creation of a new token.
        Log.d(TAG, "New token: $token")
    }

    private fun sendNotification(medicineName: String?) {
        val intent = Intent(this, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        }

        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )

        val channelId = getString(R.string.default_notification_channel_id)
        val defaultSoundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Medicine Reminder")
            .setContentText(medicineName)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create notification channel if Android O or above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Medicine Reminder Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(0, notificationBuilder.build())
    }

    suspend fun getFirebaseToken(): String? {
        return try {
            FirebaseMessaging.getInstance().token.await()
        } catch (e: Exception) {
            Log.w(TAG, "Fetching FCM registration token failed", e)
            null
        }
    }

}
