package com.evapharma.medicinereminder.features.medicine_reminder.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MedicineStatusUpdateRequest(
    @SerializedName("doctorPrescribedMedicationId") val medicationId: Int,
    @SerializedName("status") val status: String,
) : Parcelable