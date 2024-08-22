package com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewmodel

import com.evapharma.medicinereminder.core.MVIBaseViewModel
import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.UpdateMedicineStatusUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.UpdateMedicineUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.action.MedicineDetailsAction
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.result.MedicineDetailsResult
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.MedicineDetailsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MedicineDetailsViewModel @Inject constructor(
    private val updateMedicineUseCase: UpdateMedicineUseCase,
    private val updateMedicineStatusUseCase: UpdateMedicineStatusUseCase
) : MVIBaseViewModel<MedicineDetailsAction, MedicineDetailsResult, MedicineDetailsViewState>() {

    override val defaultViewState: MedicineDetailsViewState
        get() = MedicineDetailsViewState()

    override fun handleAction(action: MedicineDetailsAction): Flow<MedicineDetailsResult> {
        return flow {
            when (action) {
                is MedicineDetailsAction.UpdateMedicine -> handleUpdateMedicine(
                    collector = this,
                    action.updateMedicine
                )

                is MedicineDetailsAction.UpdateMedicineStatus -> handleUpdateMedicineStatus(
                    collector = this,
                    action.updateMedicineStatus
                )

                is MedicineDetailsAction.LoadMedicine -> handleLoadMedicine(
                    collector = this,
                    action.medicine
                )
            }
        }
    }

    //// -----------------------handle Update Medicine Action---------------------------------------------/////

    private suspend fun handleUpdateMedicine(
        collector: FlowCollector<MedicineDetailsResult>,
        medicineUpdateRequest: MedicineUpdateRequest
    ) {
        collector.emit(MedicineDetailsResult.MedicineDetails(MedicineDetailsViewState(isLoading = true)))
        val useCaseResponse = (updateMedicineUseCase(medicineUpdateRequest))
        handleUpdateMedicineUseCaseResponse(useCaseResponse, collector)
    }

    private suspend fun handleUpdateMedicineUseCaseResponse(
        useCaseResponse: DataState<Void>,
        collector: FlowCollector<MedicineDetailsResult>
    ) {
        when (useCaseResponse) {
            is DataState.Success -> {
                collector.emit(
                    MedicineDetailsResult.MedicineDetails(
                        MedicineDetailsViewState(
                            isSuccess = true
                        )
                    )
                )

                // show success Toast
            }

            is DataState.Error -> {

                // show error Toast
            }

            else -> {}
        }
    }


    //// -----------------------handle Update Medicine Status Action---------------------------------------------/////

    private suspend fun handleUpdateMedicineStatus(
        collector: FlowCollector<MedicineDetailsResult>,
        medicineStatusUpdateRequest: MedicineStatusUpdateRequest
    ) {
        collector.emit(MedicineDetailsResult.MedicineDetails(MedicineDetailsViewState(isLoading = true)))
        val useCaseResponse = (updateMedicineStatusUseCase(medicineStatusUpdateRequest))
        handleUpdateMedicineStatusUseCaseResponse(useCaseResponse, collector)
    }

    private suspend fun handleUpdateMedicineStatusUseCaseResponse(
        useCaseResponse: DataState<Void>,
        collector: FlowCollector<MedicineDetailsResult>
    ) {
        when (useCaseResponse) {
            is DataState.Success -> {
                // show success Toast
            }

            is DataState.Error -> {
                // show error Toast
            }

            else -> {}
        }
    }


    //// -----------------------handle Load Medicine Action---------------------------------------------/////
    private suspend fun handleLoadMedicine(
        collector: FlowCollector<MedicineDetailsResult>,
        medicine: Medicine
    ) {
        collector.emit(
            MedicineDetailsResult.MedicineDetails(
                MedicineDetailsViewState(
                    isSuccess = true,
                    data = medicine
                )
            )
        )

    }


}
