package com.evapharma.medicinereminder.features.medicine_reminder.data.model

import com.evapharma.medicinereminder.R

// apiName is the name when communicating with the server
enum class Status(val apiName: String, val color: Int) {
    ACTIVE(apiName = "Active", color = R.color.success),
    INACTIVE(apiName = "InActive", color = R.color.black),
    SNOOZED(apiName = "Snoozed", color = R.color.google),
    EXPIRED(apiName = "Expired", color = R.color.hint),
    STOPPED(apiName = "Stopped", color = R.color.error);

    companion object {
        fun fromString(value: String): Status? =
            entries.find { it.apiName.lowercase() == value.lowercase() }
    }
}