package com.evapharma.medicinereminder.features.medicine_reminder.presentation.contractors

import com.evapharma.medicinereminder.core.Action
import com.evapharma.medicinereminder.core.Result
import com.evapharma.medicinereminder.core.ViewState
import com.evapharma.medicinereminder.features.covid_cases.data.remote.model.CovidCasesResponse
import com.evapharma.medicinereminder.features.covid_cases.presentation.CovidCasesResults
import com.evapharma.medicinereminder.features.covid_cases.presentation.CovidCasesViewState
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest

sealed class MedicineDetailsActions:Action{
    data class UpdateMedicine (val updateMedicine: MedicineUpdateRequest): MedicineDetailsActions()
}
sealed class MedicineDetailsResults: Result<MedicineDetailsViewState> {
    data class GetMedicineDetails(val viewState: MedicineDetailsViewState) : MedicineDetailsResults() {
        override fun reduce(
            defaultState: MedicineDetailsViewState,
            oldState: MedicineDetailsViewState
        ): MedicineDetailsViewState {
          return viewState
        }
    }
}
data class MedicineDetailsViewState(
    val isIdle: Boolean = true,
    val isEmpty: Boolean = false,
    val data: CovidCasesResponse? = null,
    val error: Throwable? = null,
) : ViewState