package com.evapharma.medicinereminder.features.medicine_reminder.data.model

data class MedicineUpdateRequest(
    val id: Int,
    val newstatus: status,
    val time: String?,
    val durationFrom: String?,
    val durationTo: String?
)