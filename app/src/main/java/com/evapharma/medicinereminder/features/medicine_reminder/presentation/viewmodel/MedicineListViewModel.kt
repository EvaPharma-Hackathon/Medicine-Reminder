package com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewmodel


import com.evapharma.medicinereminder.core.MVIBaseViewModel
import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.core.models.isEmptyList
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.FrequencyType
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.PeriodType
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Status
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.GetMedicineListUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.action.MedicineListAction
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.result.MedicineListResult
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.MedicineListViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MedicineListViewModel @Inject constructor(
    private val getMedicineListUseCase: GetMedicineListUseCase,
) : MVIBaseViewModel<MedicineListAction, MedicineListResult, MedicineListViewState>() {


    override val defaultViewState: MedicineListViewState
        get() = MedicineListViewState()

    override fun handleAction(action: MedicineListAction): Flow<MedicineListResult> {
        println("handleAction")
        return flow {
            when (action) {
                is MedicineListAction.LoadMedicineList -> handleLoadMedicineList(collector = this)
            }
        }
    }

    private suspend fun handleLoadMedicineList(collector: FlowCollector<MedicineListResult>) {
        println("handleLoadMedicineList")
        collector.emit(MedicineListResult.MedicineList(MedicineListViewState(isLoading = true)))
        // add a delay to simulate a network call

        val useCaseResponse = getMedicineListUseCase()
        handleLoadMedicineListUseCaseResponse(useCaseResponse, collector)
    }

    private suspend fun handleLoadMedicineListUseCaseResponse(
        useCaseResponse: DataState<List<Medicine>>,
        collector: FlowCollector<MedicineListResult>
    ) {
        println("handleLoadMedicineListUseCaseResponse")
        // TODO: should be removed
        delay(2000)
        //
        when (useCaseResponse) {
            is DataState.Success -> {
                if (useCaseResponse.isEmptyList()) {
                    println("handleLoadMedicineListUseCaseResponse: Empty List")

                    collector.emit(
                        MedicineListResult.MedicineList(
                            MedicineListViewState(
                                isEmpty = true
                            )
                        )
                    )
                } else {
                    println("handleLoadMedicineListUseCaseResponse: ${useCaseResponse.data}")
                    collector.emit(
                        MedicineListResult.MedicineList(
                            MedicineListViewState(
                                isSuccess = true,
                                data = useCaseResponse.data,
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
}
