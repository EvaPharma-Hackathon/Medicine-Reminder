package com.evapharma.medicinereminder.features.medicine_reminder.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Medicine(
    @SerializedName("medicationId") val id: Int?,
    @SerializedName("medicationName") val name: String?,
    @SerializedName("dosage") val dosage: Int?,
    @SerializedName("status") var status: String?,
    @SerializedName("direction") val direction: String?,
    @SerializedName("durationFrom") var durationFrom: String?,
    @SerializedName("durationTo") var durationTo: String?,
    @SerializedName("time") var time: List<String>?,
    @SerializedName("frequency") val frequency: Int?,
    @SerializedName("frequencyType") val frequencyType: String?,
    @SerializedName("isChronic") val isChronic: Boolean?,
    @SerializedName("period") val period: Int?,
    @SerializedName("periodType") val periodType: String?,
) : Parcelable




fun Medicine.getStatus(): Status
{
    return Status.fromString(status ?: "") ?: Status.INACTIVE

}

fun Medicine.getMedicationFrequencyType(): PeriodType
{
    return PeriodType.fromString(frequencyType ?: "") ?: PeriodType.DAY
}

fun Medicine.getMedicationPeriodType(): PeriodType
{
    return PeriodType.fromString(periodType ?: "") ?: PeriodType.DAY
}