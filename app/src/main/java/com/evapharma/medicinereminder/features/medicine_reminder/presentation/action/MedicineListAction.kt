package com.evapharma.medicinereminder.features.medicine_reminder.presentation.action

import com.evapharma.medicinereminder.core.Action
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest

sealed class MedicineListAction : Action {
    data object LoadMedicineList : MedicineListAction()
    data class UpdateMedicineStatus(
        val request: MedicineStatusUpdateRequest,
        val showToast: (String) -> Unit = {}
    ) : MedicineListAction()
}