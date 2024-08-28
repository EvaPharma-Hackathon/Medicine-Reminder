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
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.tasks.await

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val TAG = "MyFirebaseMsgService"
    private val NOTIFICATION_ID = 1
    private val CHANNEL_ID = "medicine_reminder_channel"

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

        val defaultSoundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        // Create NotificationBuilder with high priority and full-screen intent
        val notificationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.clock_icon) // Set your small icon here
            .setContentTitle("Medicine Reminder")
            .setContentText(medicineName ?: "No medicine specified")
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)  // High priority for heads-up notification
            .setDefaults(NotificationCompat.DEFAULT_ALL)  // Use default settings for sound, vibration, etc.
            .setCategory(NotificationCompat.CATEGORY_REMINDER)  // Set category as a reminder

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create notification channel with high importance if Android O or above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelName = "Medicine Reminder Notifications"
            val channel = NotificationChannel(
                CHANNEL_ID,
                channelName,
                NotificationManager.IMPORTANCE_HIGH  // Set high importance for heads-up notifications
            ).apply {
                description = "Channel for Medicine Reminder notifications"
                enableVibration(true)  // Enable vibration
                enableLights(true)  // Enable LED light
            }
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build())
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
