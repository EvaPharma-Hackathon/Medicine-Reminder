package com.evapharma.medicinereminder.features.medicine_reminder.presentation.states

import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import kotlinx.coroutines.flow.Flow

sealed class MedicineListState {
    object Loading : MedicineListState()
    data class Success(val medicineList: Flow<List<Medicine>>) : MedicineListState()
    data class Error(val message: String) : MedicineListState()

}