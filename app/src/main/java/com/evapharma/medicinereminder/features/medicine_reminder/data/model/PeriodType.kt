package com.evapharma.medicinereminder.features.medicine_reminder.data.model

enum class PeriodType {
    DAY,
    WEEK;

    companion object {
        fun fromString(value: String): PeriodType? =
            PeriodType.entries.find { it.name.lowercase() == value.lowercase() }
    }
}