package com.evapharma.medicinereminder.features.medicine_reminder.data.model

enum class FrequencyType {
    DAILY,
    WEEKLY;

    companion object {
        fun fromString(value: String): FrequencyType? =
            FrequencyType.entries.find { it.name.lowercase() == value.lowercase() }
    }
}