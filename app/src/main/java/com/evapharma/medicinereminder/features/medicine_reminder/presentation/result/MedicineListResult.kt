package com.evapharma.medicinereminder.features.medicine_reminder.presentation.result

import com.evapharma.medicinereminder.core.Result
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.MedicineListViewState


sealed class MedicineListResult : Result<MedicineListViewState> {

    data class MedicineList(val medicineListVS: MedicineListViewState) :
        MedicineListResult() {

        override fun reduce(
            defaultState: MedicineListViewState,
            oldState: MedicineListViewState
        ): MedicineListViewState {
            return medicineListVS
        }
    }
}
