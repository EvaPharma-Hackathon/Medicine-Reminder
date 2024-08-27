package com.evapharma.medicinereminder.features.medicine_reminder.data.model

enum class PeriodType {
    DAY,
    WEEK,
    MONTH;

    companion object {
        fun fromString(value: String): PeriodType? =
            entries.find { it.name.lowercase() == value.lowercase() }
                ?: when (value) {
                    "يوم" -> DAY
                    "إسبوع" -> WEEK
                    "شهر" -> MONTH
                    else -> null
                }
    }
}