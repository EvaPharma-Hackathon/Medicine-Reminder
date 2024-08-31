package com.evapharma.medicinereminder.features.medicine_reminder.presentation.action

import com.evapharma.medicinereminder.core.Action
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest

sealed class MedicineDetailsAction : Action {
    data class LoadMedicine(val medicineId: Int) : MedicineDetailsAction()
    data class UpdateMedicine(val updateMedicine: MedicineUpdateRequest) : MedicineDetailsAction()
    data class UpdateMedicineStatus(val updateMedicineStatus: MedicineStatusUpdateRequest) :
        MedicineDetailsAction()

    data class EditInfo(val medicine: Medicine) : MedicineDetailsAction()
}