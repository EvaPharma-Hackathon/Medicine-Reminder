package com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewmodel


import com.evapharma.medicinereminder.core.MVIBaseViewModel
import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.core.models.isEmptyList
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Status
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.GetMedicineListUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.UpdateMedicineStatusUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.action.MedicineListAction
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.result.MedicineListResult
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.MedicineListViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MedicineListViewModel @Inject constructor(
    private val getMedicineListUseCase: GetMedicineListUseCase,
    private val updateMedicineStatusUseCase: UpdateMedicineStatusUseCase
) : MVIBaseViewModel<MedicineListAction, MedicineListResult, MedicineListViewState>() {


    override val defaultViewState: MedicineListViewState
        get() = MedicineListViewState()

    override fun handleAction(action: MedicineListAction): Flow<MedicineListResult> {

        return flow {
            when (action) {
                is MedicineListAction.LoadMedicineList -> handleLoadMedicineList(collector = this)
                is MedicineListAction.UpdateMedicineStatus -> handleUpdateMedicineStatus(
                    collector = this, request = action.request, showToast = action.showToast
                )
            }
        }
    }

    private suspend fun handleLoadMedicineList(collector: FlowCollector<MedicineListResult>) {

        collector.emit(MedicineListResult.MedicineList(MedicineListViewState(isLoading = true)))
        // add a delay to simulate a network call

        val useCaseResponse = getMedicineListUseCase()

        println("useCaseResponse: $useCaseResponse")
        handleLoadMedicineListUseCaseResponse(useCaseResponse, collector)
    }

    private suspend fun handleLoadMedicineListUseCaseResponse(
        useCaseResponse: DataState<List<Medicine>>,
        collector: FlowCollector<MedicineListResult>
    ) {

        when (useCaseResponse) {
            is DataState.Success -> {
                if (useCaseResponse.isEmptyList()) {
                    collector.emit(
                        MedicineListResult.MedicineList(
                            MedicineListViewState(
                                isEmpty = true
                            )
                        )
                    )
                } else {
                    // filter out stopped medicines
                    val filteredList =
                        useCaseResponse.data.filter { it.status?.lowercase() != Status.STOPPED.apiName.lowercase() }
                    collector.emit(
                        MedicineListResult.MedicineList(
                            MedicineListViewState(
                                isSuccess = true,
                                data = filteredList,
                            )
                        )
                    )
                }
            }

            else -> {
                collector.emit(
                    MedicineListResult.MedicineList(
                        MedicineListViewState(
                            error = Throwable(message = useCaseResponse.reason?.get(0))
                        )
                    )
                )
            }
        }
    }


    // TODO: this implementation doesn't follow mvi principles but is made due to lack of time
    private suspend fun handleUpdateMedicineStatus(
        collector: FlowCollector<MedicineListResult>,
        request: MedicineStatusUpdateRequest,
        showToast: (String) -> Unit = {}
    ) {
        collector.emit(MedicineListResult.MedicineList(MedicineListViewState(isLoading = true)))
        val response = updateMedicineStatusUseCase(
            updateRequest = request
        )
        handleUpdateMedicineStatusUseCaseResponse(response, showToast)

    }


    private suspend fun handleUpdateMedicineStatusUseCaseResponse(
        response: DataState<Any>,
        showToast: (String) -> Unit = {}
    ) {
        when (response) {
            is DataState.Success -> {
                showToast("Medicine status updated successfully")
                executeAction(MedicineListAction.LoadMedicineList)
            }

            else -> {
                showToast("Error updating medicine status")
            }
        }

    }
}
