package com.evapharma.medicinereminder.features.medicine_reminder.data.model

// apiName is the name when communicating with the server
enum class Status(val apiName: String) {
    ACTIVE(apiName = "Active"),
    INACTIVE(apiName = "Inactive"),
    SNOOZED(apiName = "Snoozed"),
    EXPIRED(apiName = "Expired"),
    STOPPED(apiName = "Stopped");

    companion object {
        fun fromString(value: String): Status? =
            entries.find { it.apiName.lowercase() == value.lowercase() }
    }
}