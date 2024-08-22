package com.evapharma.medicinereminder.features.medicine_reminder.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate
import java.time.LocalTime

@Parcelize
data class Medicine(
    val medicationId:Int,
    val medicationName: String,
    val dosage: String?,
    val directions: String,
    var time: String?,
    var durationFrom: String?,
    var durationTo: String?,
    val frequency: Int,
    val isChronic: Boolean,
    val period: Int,
    var status: status=com.evapharma.medicinereminder.features.medicine_reminder.data.model.status.INACTIVE,
    val periodType: periodType,
    val frequencyType: frequencyType,

) : Parcelable

enum class status {
    ACTIVE,
    INACTIVE,
    SNOOZED,
    EXPIRED,
    STOP
}
enum class periodType
{
    DAY,
    WEEK
}
enum class frequencyType{
    DAILY,
    WEEKLY
}