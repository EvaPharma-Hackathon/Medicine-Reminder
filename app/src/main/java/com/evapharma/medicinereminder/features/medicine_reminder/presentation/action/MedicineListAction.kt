package com.evapharma.medicinereminder.features.medicine_reminder.presentation.action

import com.evapharma.medicinereminder.core.Action

sealed class MedicineListAction : Action {
    data object LoadMedicineList : MedicineListAction()
}