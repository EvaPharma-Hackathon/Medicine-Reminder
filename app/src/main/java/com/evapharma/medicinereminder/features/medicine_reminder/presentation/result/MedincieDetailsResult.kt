package com.evapharma.medicinereminder.features.medicine_reminder.presentation.result

import com.evapharma.medicinereminder.core.Result
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.MedicineDetailsViewState


sealed class MedicineDetailsResult : Result<MedicineDetailsViewState> {
    data class MedicineDetails(val medicineDetailsVS: MedicineDetailsViewState) :
        MedicineDetailsResult() {

        override fun reduce(
            defaultState: MedicineDetailsViewState,
            oldState: MedicineDetailsViewState
        ): MedicineDetailsViewState {
            return medicineDetailsVS.copy(
                data = medicineDetailsVS.data ?: oldState.data
            )
        }
    }


}