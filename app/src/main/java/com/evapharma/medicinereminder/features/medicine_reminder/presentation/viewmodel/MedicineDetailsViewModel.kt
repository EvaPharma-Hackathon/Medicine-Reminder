package com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewmodel

import com.evapharma.medicinereminder.core.MVIBaseViewModel
import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.GetMedicineUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.UpdateMedicineStatusUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.UpdateMedicineUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.action.MedicineDetailsAction
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.result.MedicineDetailsResult
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.MedicineDetailsViewState
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.MedicineUpdateViewState
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.MedicineViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MedicineDetailsViewModel @Inject constructor(
    private val updateMedicineUseCase: UpdateMedicineUseCase,
    private val updateMedicineStatusUseCase: UpdateMedicineStatusUseCase,
    private val getMedicineUseCase: GetMedicineUseCase
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
                    action.medicineId
                )
            }
        }
    }

    //// -----------------------handle Update Medicine Action---------------------------------------------/////

    private suspend fun handleUpdateMedicine(
        collector: FlowCollector<MedicineDetailsResult>,
        medicineUpdateRequest: MedicineUpdateRequest
    ) {
        collector.emit(
            MedicineDetailsResult.MedicineDetails(
                MedicineDetailsViewState(
                    medicineUpdateViewState = MedicineUpdateViewState(isLoading = true)
                )
            )
        )
        val useCaseResponse = (updateMedicineUseCase(medicineUpdateRequest))
        handleUpdateMedicineUseCaseResponse(useCaseResponse, collector)
    }

    private suspend fun handleUpdateMedicineUseCaseResponse(
        useCaseResponse: DataState<Any>,
        collector: FlowCollector<MedicineDetailsResult>
    ) {

        // TODO : should be removed
        delay(1000)

        ///
        when (useCaseResponse) {
            is DataState.Success -> {
                collector.emit(
                    MedicineDetailsResult.MedicineDetails(
                        MedicineDetailsViewState(
                            medicineUpdateViewState = MedicineUpdateViewState(isSuccess = true)
                        )
                    )
                )

                // show success Toast
            }

            else -> {

                collector.emit(
                    MedicineDetailsResult.MedicineDetails(
                        MedicineDetailsViewState(
                            medicineUpdateViewState = MedicineUpdateViewState(
                                error = Throwable(message = useCaseResponse.reason?.get(0))
                            )
                        )
                    )
                )

                // show error Toast
            }
        }
    }


    //// -----------------------handle Update Medicine Status Action---------------------------------------------/////

    private suspend fun handleUpdateMedicineStatus(
        collector: FlowCollector<MedicineDetailsResult>,
        medicineStatusUpdateRequest: MedicineStatusUpdateRequest
    ) {
        collector.emit(
            MedicineDetailsResult.MedicineDetails(
                MedicineDetailsViewState(

                    medicineUpdateViewState = MedicineUpdateViewState(isLoading = true)
                )
            )
        )
        val useCaseResponse = (updateMedicineStatusUseCase(medicineStatusUpdateRequest))
        handleUpdateMedicineStatusUseCaseResponse(useCaseResponse, collector)
    }

    private suspend fun handleUpdateMedicineStatusUseCaseResponse(
        useCaseResponse: DataState<Any>,
        collector: FlowCollector<MedicineDetailsResult>
    ) {
        // TODO : should be removed
        delay(1000)
        ///
        when (useCaseResponse) {
            is DataState.Success -> {
                collector.emit(
                    MedicineDetailsResult.MedicineDetails(
                        MedicineDetailsViewState(
                            medicineUpdateViewState = MedicineUpdateViewState(isSuccess = true)
                        )
                    )
                )
                // show success Toast
            }

            else -> {
                // show error Toast

                collector.emit(
                    MedicineDetailsResult.MedicineDetails(
                        MedicineDetailsViewState(
                            medicineUpdateViewState = MedicineUpdateViewState(
                                error = Throwable(
                                    message = useCaseResponse.reason?.get(0)
                                )
                            )
                        )
                    )
                )
            }
        }
    }


    //// -----------------------handle Load Medicine Action---------------------------------------------/////
    private suspend fun handleLoadMedicine(
        collector: FlowCollector<MedicineDetailsResult>,
        medicineId: Int
    ) {
        collector.emit(
            MedicineDetailsResult.MedicineDetails(
                MedicineDetailsViewState(
                    medicationViewState = MedicineViewState(isLoading = true)
                )
            )
        )
        val useCaseResponse = (getMedicineUseCase(medicineId = medicineId))
        handleLoadMedicineUseCaseResponse(useCaseResponse, collector)

    }


    private suspend fun handleLoadMedicineUseCaseResponse(
        useCaseResponse: DataState<Medicine>,
        collector: FlowCollector<MedicineDetailsResult>
    ) {
        // TODO : should be removed
        delay(1000)

        ///
        when (useCaseResponse) {
            is DataState.Success -> {
                collector.emit(
                    MedicineDetailsResult.MedicineDetails(
                        MedicineDetailsViewState(
                            medicationViewState = MedicineViewState(
                                isSuccess = true,
                                data = useCaseResponse.data
                            )
                        )
                    )
                )
            }

            else -> {
                collector.emit(
                    MedicineDetailsResult.MedicineDetails(
                        MedicineDetailsViewState(
                            medicationViewState = MedicineViewState(
                                error = Throwable(
                                    message = (useCaseResponse as DataState.Error).reason?.get(0)
                                )
                            )

                        )
                    )
                )

            }
        }
    }


}
