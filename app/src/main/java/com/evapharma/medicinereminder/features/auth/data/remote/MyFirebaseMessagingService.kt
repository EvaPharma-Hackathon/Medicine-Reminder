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
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.tasks.await
import org.json.JSONObject
import java.util.regex.Pattern


@AndroidEntryPoint
class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val TAG = "MyFirebaseMsgService"
    private val NOTIFICATION_ID = 19578
    private val CHANNEL_ID = "medicine_reminder_channel"

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.d(TAG, "onMessageReceived: $remoteMessage")
//        // Handle FCM messages here.
//        remoteMessage.notification?.let {
//            sendNotification(it.body)
//        }

        Log.d(TAG, "onMessageReceived: ${remoteMessage.data}")
        Log.d(TAG, "onMessageReceived Title: ${remoteMessage.data["title"]}")
        Log.d(TAG, "onMessageReceived Body: ${remoteMessage.data["body"]}")


        val jsonObject = remoteMessage.data["body"]?.let { JSONObject(it) } ?: return

        // Extract values
        val title = remoteMessage.data["title"]
        val message = decodeUnicodeString(jsonObject.getString("Message"))
        val medicationId = jsonObject.getInt("MedicationId")

        Log.d(TAG, "onMessageReceived message: $message")
        Log.d(TAG, "onMessageReceived medicationId: $medicationId")


        sendNotification(title, message, medicationId)
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // Handle the creation of a new token.
        Log.d(TAG, "New token: $token")
    }

    private fun sendNotification(title: String?, body: String?, medicationId: Int) {

        // Start MainActivity with the ID
        val intent = Intent(this, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            putExtra("medicationId", medicationId)
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
            .setContentTitle(title ?: "No title specified")
            .setContentText(body ?: "No body specified")
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)  // High priority for heads-up notification
            .setDefaults(NotificationCompat.DEFAULT_ALL)  // Use default settings for sound, vibration, etc.
            .setCategory(NotificationCompat.CATEGORY_REMINDER)  // Set category as a reminder

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

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


    private fun decodeUnicodeString(input: String): String {
        // Regex pattern to find Unicode escape sequences like \uXXXX
        val unicodePattern = Pattern.compile("\\\\u([0-9A-Fa-f]{4})")
        val matcher = unicodePattern.matcher(input)
        val buffer = StringBuffer()

        while (matcher.find()) {
            // Convert the hex code to an integer, then to a character
            val unicodeChar = matcher.group(1)?.toInt(16)?.toChar()
            matcher.appendReplacement(buffer, unicodeChar.toString())
        }
        matcher.appendTail(buffer)

        return buffer.toString()
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
