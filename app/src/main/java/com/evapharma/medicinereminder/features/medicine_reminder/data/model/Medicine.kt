package com.evapharma.medicinereminder.features.medicine_reminder.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Medicine(
    val id:Int,
    val title: String,
    val dosage: String,
    val instructions: String,
    val time: String,
    val durationFrom: String,
    val durationTo: String
) : Parcelable