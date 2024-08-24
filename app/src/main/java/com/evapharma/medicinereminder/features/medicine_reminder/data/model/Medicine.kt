package com.evapharma.medicinereminder.features.medicine_reminder.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Medicine(
    @SerializedName("medicationId") val id: Int?,
    @SerializedName("medicationName") val name: String,
    @SerializedName("dosage") val dosage: String?,
    @SerializedName("titration") val titration: String?,
    @SerializedName("status") var status: Status?,
    @SerializedName("unit") val unit: String?,
    @SerializedName("direction") val direction: String?,
    @SerializedName("durationFrom") var durationFrom: String?,
    @SerializedName("durationTo") var durationTo: String?,
    @SerializedName("time") var time: List<String>?,
    @SerializedName("frequency") val frequency: Int?,
    @SerializedName("frequencyType") val frequencyType: FrequencyType?,
    @SerializedName("isChronic") val isChronic: Boolean?,
    @SerializedName("period") val period: Int?,
    @SerializedName("periodType") val periodType: PeriodType?,
) : Parcelable