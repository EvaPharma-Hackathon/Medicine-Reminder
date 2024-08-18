package com.evapharma.medicinereminder.features.medicine_reminder.presentation.states

import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine

sealed class MedicineDetailsState {
    object Loading : MedicineDetailsState()
    data class Success(val medicine: Medicine) : MedicineDetailsState()
    data class Error(val message: String) : MedicineDetailsState()
}