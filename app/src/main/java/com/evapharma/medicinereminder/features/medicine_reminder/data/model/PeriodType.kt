package com.evapharma.medicinereminder.features.medicine_reminder.data.model

enum class PeriodType(val alternateValues: List<String> = emptyList()) {
    DAY(alternateValues = listOf("يوم", "daily")),
    WEEK(alternateValues = listOf("اسبوع", "weekly")),
    MONTH(alternateValues = listOf("شهر", "monthly"));

    companion object {
        fun fromString(value: String): PeriodType? =
            entries.find { type -> type.name.lowercase() == value.lowercase() || type.alternateValues.any { alternateValue -> alternateValue.lowercase() == value.lowercase() } }
    }
}