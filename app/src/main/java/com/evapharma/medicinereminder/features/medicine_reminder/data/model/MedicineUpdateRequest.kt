package com.evapharma.medicinereminder.features.medicine_reminder.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MedicineUpdateRequest(
    @SerializedName("medicationId") val medicationId: Int,
    @SerializedName("status") val status: String,
    @SerializedName("time") val time: List<String>,
    @SerializedName("durationFrom") val durationFrom: String,
    @SerializedName("durationTo") val durationTo: String
) : Parcelable