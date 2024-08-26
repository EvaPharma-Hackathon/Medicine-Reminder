package com.evapharma.medicinereminder.features.auth.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginRequest(
    @SerializedName("deviceToken") val deviceToken: String?,
    @SerializedName("os") val os: String?,
    @SerializedName("phoneNumber") val phoneNumber: String?
) : Parcelable