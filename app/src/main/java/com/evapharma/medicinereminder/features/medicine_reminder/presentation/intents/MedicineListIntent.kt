package com.evapharma.medicinereminder.features.medicine_reminder.presentation.intents

sealed class MedicineListIntent {
    object LoadMedicineList : MedicineListIntent()
    data class SelectMedicine(val medicineId: Int) : MedicineListIntent()
}