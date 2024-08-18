package com.evapharma.medicinereminder.features.medicine_reminder.presentation.intents

sealed class MedicineDetailsIntent {
    data class LoadMedicineDetails(val medicineId: Int) : MedicineDetailsIntent()
}