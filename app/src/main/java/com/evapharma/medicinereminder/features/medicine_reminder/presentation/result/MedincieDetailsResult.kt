package com.evapharma.medicinereminder.features.medicine_reminder.presentation.result

import com.evapharma.medicinereminder.core.Result
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.MedicineDetailsViewState
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.MedicineUpdateViewState


sealed class MedicineDetailsResult : Result<MedicineDetailsViewState> {
    data class MedicineDetails(val medicineDetailsVS: MedicineDetailsViewState) :
        MedicineDetailsResult() {

        override fun reduce(
            defaultState: MedicineDetailsViewState,
            oldState: MedicineDetailsViewState
        ): MedicineDetailsViewState {
            return oldState.copy(
                medicationViewState = medicineDetailsVS.medicationViewState
                    ?: oldState.medicationViewState,
                medicineUpdateViewState = medicineDetailsVS.medicineUpdateViewState
                    ?: MedicineUpdateViewState()

            )
        }
    }

    data class MedicineUpdate(val medicineUpdateVS: MedicineDetailsViewState) :
        MedicineDetailsResult() {
        override fun reduce(
            defaultState: MedicineDetailsViewState,
            oldState: MedicineDetailsViewState
        ): MedicineDetailsViewState {
            return oldState.copy(
                medicationViewState = medicineUpdateVS.medicationViewState
                    ?: oldState.medicationViewState,
                medicineUpdateViewState = medicineUpdateVS.medicineUpdateViewState
                    ?: MedicineUpdateViewState()
            )
        }
    }

}