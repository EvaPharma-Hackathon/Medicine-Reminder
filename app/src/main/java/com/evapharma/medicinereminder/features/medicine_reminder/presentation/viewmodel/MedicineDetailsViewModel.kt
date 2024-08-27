package com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.evapharma.medicinereminder.core.MVIBaseViewModel
import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.core.utils.Constants
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.PeriodType
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.getMedicationFrequencyType
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.getMedicationPeriodType
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.GetMedicineUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.UpdateMedicineStatusUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.UpdateMedicineUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.action.MedicineDetailsAction
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.result.MedicineDetailsResult
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.MedicineDetailsViewState
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.MedicineUpdateViewState
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.MedicineViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MedicineDetailsViewModel @Inject constructor(
    private val updateMedicineUseCase: UpdateMedicineUseCase,
    private val updateMedicineStatusUseCase: UpdateMedicineStatusUseCase,
    private val getMedicineUseCase: GetMedicineUseCase
) : MVIBaseViewModel<MedicineDetailsAction, MedicineDetailsResult, MedicineDetailsViewState>() {
    override val defaultViewState: MedicineDetailsViewState
        get() = MedicineDetailsViewState()


    // needed state for editInfo
    private var currentMedicine: Medicine? = null


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

                is MedicineDetailsAction.EditInfo -> handleEditInfo(
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
        collector.emit(
            MedicineDetailsResult.Medicine(
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
        when (useCaseResponse) {
            is DataState.Success -> {
                collector.emit(
                    MedicineDetailsResult.MedicineStatusUpdate(
                        MedicineDetailsViewState(
                            medicineUpdateViewState = MedicineUpdateViewState(isSuccess = true)
                        )
                    )
                )

                // show success Toast
            }

            else -> {

                collector.emit(
                    MedicineDetailsResult.MedicineStatusUpdate(
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
            MedicineDetailsResult.MedicineStatusUpdate(
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
        when (useCaseResponse) {
            is DataState.Success -> {
                collector.emit(
                    MedicineDetailsResult.MedicineStatusUpdate(
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
                    MedicineDetailsResult.MedicineStatusUpdate(
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
            MedicineDetailsResult.Medicine(
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
        when (useCaseResponse) {
            is DataState.Success -> {
                currentMedicine = useCaseResponse.data
                collector.emit(
                    MedicineDetailsResult.Medicine(
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
                    MedicineDetailsResult.Medicine(
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


    /// -----------------------handle Edit Info Action---------------------------------------------/////

    private suspend fun handleEditInfo(
        collector: FlowCollector<MedicineDetailsResult>,
        medicine: Medicine
    ) {
        currentMedicine = medicine
        collector.emit(
            MedicineDetailsResult.Medicine(
                MedicineDetailsViewState(
                    medicationViewState = MedicineViewState(
                        isSuccess = true,
                        data = medicine
                    )
                )
            )
        )
    }

    /// required functions


    fun setMedicationTimes(
        hour: Int,
        minute: Int,
        viewSelections: (String, String, List<String>) -> Unit
    ) {


        viewModelScope.launch {
            val currentDate = Date()  // This gets the current date and time
            val formatter = SimpleDateFormat(Constants.YEAR_MONTH_DAY_FORMAT, Locale.getDefault())
            val durationFrom = formatter.format(currentDate)
            var durationTo: String
            var medicationTimes: List<String>

            viewStates.value.medicationViewState?.data?.let { medication ->
                val newPeriod =
                    if (medication.period == null || medication.period <= 0) 1 else medication.period
                durationTo = formatter.format(
                    currentDate.addDays(
                        when (medication.getMedicationPeriodType()) {
                            PeriodType.DAY -> newPeriod
                            PeriodType.WEEK -> (newPeriod.times(7))
                            PeriodType.MONTH -> (newPeriod.times(30))
                        }
                    )
                )

                val newFrequency =
                    if (medication.frequency == null || medication.frequency <= 0) 1 else medication.frequency


                medicationTimes = generateTimesWithInterval(
                    hour, minute, when (medication.getMedicationFrequencyType()) {
                        PeriodType.DAY -> newFrequency
                        else -> 1
                    }
                )

                viewSelections(durationFrom, durationTo, medicationTimes)

            }


        }


    }

    private fun generateTimesWithInterval(hour: Int, minute: Int, elements: Int): List<String> {
        // Calculate the total number of hours in a day
        val totalHoursInDay = 24

        // Calculate the time interval in hours based on the number of elements
        val intervalHours = totalHoursInDay / elements

        // Initialize a Calendar instance with the given hour and minute
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }

        // Create a SimpleDateFormat to format the output
        val formatter = SimpleDateFormat("HH:mm:ss", Locale.getDefault())

        // Generate the times based on the calculated interval
        val timeList = mutableListOf<String>()
        for (i in 0 until elements) {
            // Format the current time and add it to the list
            val time = formatter.format(calendar.time)
            timeList.add(time)

            // Add the interval hours to the calendar
            calendar.add(Calendar.HOUR_OF_DAY, intervalHours)
        }

        println("timeList: $timeList")

        return timeList
    }


    private fun Date.addDays(daysToAdd: Int): Date {
        // Get the current date
        val calendar = Calendar.getInstance()
        calendar.time = this

        // Add the specified number of days
        calendar.add(Calendar.DAY_OF_YEAR, daysToAdd)

        // Get the updated date
        val newDate = calendar.time

        return newDate
    }


}
