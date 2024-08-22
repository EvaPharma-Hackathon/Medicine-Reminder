package com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewmodels

import com.evapharma.medicinereminder.core.BaseViewModel
import com.evapharma.medicinereminder.core.MVIBaseViewModel
import com.evapharma.medicinereminder.features.covid_cases.presentation.CovidCasesActions
import com.evapharma.medicinereminder.features.covid_cases.presentation.CovidCasesViewState
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.status
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.UpdateMedicineUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.contractors.MedicineDetailsActions
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.contractors.MedicineDetailsResults
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.contractors.MedicineDetailsViewState
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.intents.MedicineListIntent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MedicineDetailsViewModel @Inject constructor (private val updateMedicineUseCase: UpdateMedicineUseCase):
    MVIBaseViewModel<MedicineDetailsActions,MedicineDetailsResults,MedicineDetailsViewState>()
{


    override val defaultViewState: MedicineDetailsViewState
        get() = MedicineDetailsViewState(isIdle = true)

    override fun handleAction(action: MedicineDetailsActions): Flow<MedicineDetailsResults> {
        return flow {
            when (action) {
                is MedicineDetailsActions.UpdateMedicine -> {
                    updateMedicine(
                        action.updateMedicine.id,
                        action.updateMedicine.newstatus,
                        action.updateMedicine.time,
                        action.updateMedicine.durationFrom,
                        action.updateMedicine.durationTo

                    )
                }
            }

        }    }
    private fun updateMedicine(
        medicineId: Int,
        newStatus: status,
        time: String?,
        durationFrom: String?,
        durationTo: String?
    ) {
        updateMedicineUseCase.invoke(
            medicineId = medicineId,
            newStatus = newStatus,
            time = time,
            durationFrom = durationFrom,
            durationTo = durationTo
        )
    }
}