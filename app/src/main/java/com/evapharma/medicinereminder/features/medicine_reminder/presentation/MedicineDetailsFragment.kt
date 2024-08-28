package com.evapharma.medicinereminder.features.medicine_reminder.presentation

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.evapharma.medicinereminder.MainActivity
import com.evapharma.medicinereminder.R
import com.evapharma.medicinereminder.core.BaseFragment
import com.evapharma.medicinereminder.core.utils.Constants
import com.evapharma.medicinereminder.databinding.FragmentMedicineDetailsBinding
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Status
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.getMedicationFrequencyType
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.getMedicationPeriodType
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.getStatus
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.toUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.action.MedicineDetailsAction
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.adapters.MedicationTimesAdapter
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewmodel.MedicineDetailsViewModel
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.MedicineDetailsViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.abs

@AndroidEntryPoint
class MedicineDetailsFragment :
    BaseFragment<FragmentMedicineDetailsBinding, MedicineDetailsViewModel>() {

    private var medicineId: String? = null

    override fun initBinding(): FragmentMedicineDetailsBinding {
        return FragmentMedicineDetailsBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this)[MedicineDetailsViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        medicineId = MedicineDetailsFragmentArgs.fromBundle(requireArguments()).medicineId
    }

    override fun onFragmentCreated() {


        // Set up the Medication Times RecyclerView
        val adapter = MedicationTimesAdapter(emptyList())

        binding.MedicationTimes.medicationsTimesRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())
        binding.MedicationTimes.medicationsTimesRecyclerView.adapter = adapter

        binding.leftIcon.setOnClickListener {
            findNavController().navigateUp()
        }

        (activity as? MainActivity)?.setTryAgainListener {
            viewModel.executeAction(
                MedicineDetailsAction.LoadMedicine(
                    medicineId = medicineId?.toInt() ?: 0
                )
            )
        }

    }


    override fun onResume() {


        super.onResume()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.viewStates.collect { state ->
                // Handle the state update here
                updateUI(state)
            }
        }


        // Trigger the loading of medicine details
        if (viewModel.currentMedicine == null) {
            viewModel.executeAction(
                MedicineDetailsAction.LoadMedicine(
                    medicineId = medicineId?.toInt() ?: 0
                )
            )
        }
    }


    private fun updateUI(state: MedicineDetailsViewState) {
        // Update the UI based on the state


        val medicineState = state.medicationViewState
        val medicineUpdateState = state.medicineUpdateViewState
        if (medicineState?.isLoading == true || medicineUpdateState?.isLoading == true) {
            (activity as MainActivity).showLoadingSpinner()

        } else {
            medicineState?.let { medState ->


                if (medState.isSuccess) {

                    (activity as MainActivity).showMainContent()




                    medState.data?.let {
                        binding.title.text = it.name
                        binding.status.text = it.getStatus().apiName
                        binding.status.setTextColor(
                            ContextCompat.getColor(
                                requireContext(), it.getStatus().color
                            )
                        )


                        (binding.MedicationTimes.medicationsTimesRecyclerView.adapter as MedicationTimesAdapter).setOnEditTime { timeIndex ->
                            //TODO: show save changes button if active

                            showTimePickerDialog(timeIndex = timeIndex)

                            if (it.getStatus() == Status.ACTIVE) {

                                binding.MedicationTimes.saveChangesBtn.root.visibility =
                                    View.VISIBLE

                            }

                        }


                        /// dosage data
                        binding.MedicineDetailsDosage.root.visibility = View.VISIBLE
                        binding.MedicineDetailsDosage.title.text = getString(R.string.dosage)
                        binding.MedicineDetailsDosage.details.text =
                            it.dosage?.takeIf { dosage -> dosage > 0 }?.toString() ?: "No dosage"

                        /// Instructions data
                        binding.MedicineDetailsInstructions.root.visibility = View.VISIBLE
                        binding.MedicineDetailsInstructions.title.text = "Instructions"
                        binding.MedicineDetailsInstructions.details.text =
                            it.direction?.takeIf { direction -> direction.isNotBlank() }
                                ?: "No instructions"


                        // Medication Duration data
                        binding.MedicineCardDuration.root.visibility = View.VISIBLE
                        binding.MedicineCardDuration.setStartBtn.root.visibility = View.GONE

                        val newPeriod = if (it.period == null || it.period <= 0) 1 else it.period
                        var period =
                            "$newPeriod ${it.getMedicationPeriodType().toString().lowercase()}"
                        period = if (newPeriod == 1) period else "${period}s"
                        binding.MedicineCardDuration.period.text = period
                        if (it.durationFrom.isNullOrBlank()) {
                            binding.MedicineCardDuration.DurationFrom.text = "Unspecified"
                        } else {
                            binding.MedicineCardDuration.DurationFrom.text = convertDateFormat(it.durationFrom ?: "")
                        }
                        if (it.durationTo.isNullOrBlank()) {
                            binding.MedicineCardDuration.DurationTo.text = "Unspecified"
                        } else {
                            binding.MedicineCardDuration.DurationTo.text = convertDateFormat(it.durationTo ?: "")
                        }


                        // Medication Times
                        binding.MedicationTimes.root.visibility = View.VISIBLE

                        val newFrequency =
                            if (it.frequency == null || it.frequency <= 0) 1 else it.frequency
                        val frequency = if (newFrequency == 1) getString(
                            R.string.one_time_per, it.getMedicationFrequencyType().name.lowercase()
                        ) else getString(
                            R.string.times_per,
                            newFrequency,
                            it.getMedicationFrequencyType().name.lowercase()
                        )
                        binding.MedicationTimes.frequency.text = frequency

                        it.time?.let { medicationTimes ->
                            (binding.MedicationTimes.medicationsTimesRecyclerView.adapter as MedicationTimesAdapter).updateData(
                                newMedicationTimes = medicationTimes,
                                isEditable = (it.getStatus() == Status.ACTIVE || it.getStatus() == Status.INACTIVE)
                            )
                        }


                        // buttons to show according to status
                        when (it.getStatus()) {
                            Status.ACTIVE -> {

                                binding.MedicationTimes.saveChangesBtn.btnAction.setOnClickListener {
                                    binding.MedicationTimes.saveChangesBtn.root.visibility =
                                        View.GONE
                                    activateOrUpdate(Status.ACTIVE.apiName)
                                }

                                binding.statusInverterBtn.visibility = View.VISIBLE
                                binding.statusInverterBtn.text =
                                    getString(R.string.snooze_medication_reminder)
                                binding.statusInverterBtn.setBackgroundColor(
                                    ContextCompat.getColor(
                                        requireContext(), R.color.primary_variant
                                    )
                                )
                                binding.statusInverterBtn.setOnClickListener {

                                    showConfirmationDialog(message = getString(R.string.are_you_sure_you_want_to_snooze_this_medication),
                                        performAction = {
                                            viewModel.executeAction(
                                                MedicineDetailsAction.UpdateMedicineStatus(
                                                    MedicineStatusUpdateRequest(
                                                        medicationId = medicineId?.toInt() ?: 0,
                                                        status = Status.SNOOZED.apiName
                                                    )
                                                )
                                            )
                                        })
                                }

                                if (it.isChronic == true) {
                                    binding.stopMedicationBtn.visibility = View.GONE
                                    binding.isChronicWarningMessage.visibility = View.VISIBLE
                                } else {
                                    binding.stopMedicationBtn.visibility = View.VISIBLE
                                    binding.isChronicWarningMessage.visibility = View.GONE
                                    binding.stopMedicationBtn.text =
                                        getString(R.string.stop_medication)
                                    binding.stopMedicationBtn.setBackgroundColor(
                                        ContextCompat.getColor(
                                            requireContext(), R.color.error
                                        )
                                    )
                                    binding.stopMedicationBtn.setOnClickListener {
                                        showConfirmationDialog(message = getString(R.string.are_you_sure_you_want_to_stop_this_medication),
                                            performAction = {
                                                viewModel.executeAction(
                                                    MedicineDetailsAction.UpdateMedicineStatus(
                                                        MedicineStatusUpdateRequest(
                                                            medicationId = medicineId?.toInt() ?: 0,
                                                            status = Status.STOPPED.apiName
                                                        )
                                                    )
                                                )
                                                findNavController().navigateUp()
                                            })
                                    }
                                }

                            }

                            Status.INACTIVE -> {
                                binding.MedicationTimes.saveChangesBtn.root.visibility = View.GONE
                                binding.MedicineCardDuration.setStartBtn.root.visibility =
                                    View.VISIBLE
                                binding.MedicineCardDuration.setStartBtn.btnAction.text =
                                    "Edit Start Date"
                                binding.MedicineCardDuration.setStartBtn.root.setOnClickListener {
                                    showDatePickerDialog()
                                }



                                binding.isChronicWarningMessage.visibility = View.GONE
                                binding.stopMedicationBtn.visibility = View.GONE

                                binding.statusInverterBtn.visibility = View.VISIBLE
                                binding.statusInverterBtn.text = getString(R.string.activate)
                                binding.statusInverterBtn.setBackgroundColor(
                                    ContextCompat.getColor(
                                        requireContext(), R.color.success
                                    )
                                )
                                binding.statusInverterBtn.setOnClickListener {

                                    activateOrUpdate(Status.ACTIVE.apiName)

                                }
                                binding.statusInverterBtn.visibility =
                                    if (viewModel.readyToActivate()) View.VISIBLE else View.GONE
                            }

                            Status.SNOOZED -> {
                                binding.MedicationTimes.saveChangesBtn.root.visibility = View.GONE
                                binding.statusInverterBtn.visibility = View.GONE

                                if (it.isChronic == true) {
                                    binding.stopMedicationBtn.visibility = View.GONE
                                    binding.isChronicWarningMessage.visibility = View.VISIBLE
                                } else {
                                    binding.stopMedicationBtn.visibility = View.VISIBLE
                                    binding.isChronicWarningMessage.visibility = View.GONE
                                    binding.stopMedicationBtn.setOnClickListener {
                                        showConfirmationDialog(message = getString(R.string.are_you_sure_you_want_to_stop_this_medication),
                                            performAction = {
                                                viewModel.executeAction(
                                                    MedicineDetailsAction.UpdateMedicineStatus(
                                                        MedicineStatusUpdateRequest(
                                                            medicationId = medicineId?.toInt() ?: 0,
                                                            status = Status.STOPPED.apiName
                                                        )
                                                    )
                                                )
                                                findNavController().navigateUp()
                                            })
                                    }
                                }
                            }

                            else -> {
                                binding.MedicationTimes.saveChangesBtn.root.visibility = View.GONE
                                binding.MedicineCardDuration.setStartBtn.root.visibility = View.GONE
                                binding.stopMedicationBtn.visibility = View.GONE
                                binding.statusInverterBtn.visibility = View.GONE
                                binding.isChronicWarningMessage.visibility = View.GONE


                            }
                        }
                    }
                } else if (medState.isEmpty) {
                    (activity as MainActivity).showEmptyView(text = "Medicine not found")
                } else if (medState.error != null) {
                    (activity as MainActivity).showErrorView()
                } else {
                }
            }

            medicineUpdateState?.let { medUpdateStatus ->
                if (medUpdateStatus.isSuccess) {
                    (activity as MainActivity).showMainContent()
                    // show toast
                    showToast(getString(R.string.medicine_updated_successfully))
                    viewModel.executeAction(
                        MedicineDetailsAction.LoadMedicine(
                            medicineId = medicineId?.toInt() ?: 0
                        )
                    )

                } else if (medUpdateStatus.error != null) {
                    (activity as MainActivity).showMainContent()
                    // show error toast
                    showToast(getString(R.string.error_updating_medicine_status))

                } else {
                }

            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }


    private fun showConfirmationDialog(
        message: String = getString(R.string.are_you_sure), performAction: () -> Unit
    ) {
        // Create an instance of AlertDialog.Builder
        val builder = AlertDialog.Builder(requireContext())

        // Set the dialog title and message
        builder.setTitle(getString(R.string.confirm_action))
        builder.setMessage(message)

        // Set the positive button and its click listener
        builder.setPositiveButton(getString(R.string.yes)) { dialog, _ ->
            // Handle positive button action here
            performAction()
            dialog.dismiss()
        }

        // Set the negative button and its click listener
        builder.setNegativeButton(getString(R.string.no)) { dialog, _ ->
            // Handle negative button action here
            dialog.dismiss()
        }

        // Create and show the dialog
        val dialog = builder.create()
        dialog.show()
    }


    private fun showTimePickerDialog(timeIndex: Int) {
        // Get the current time as default values
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        // Create a TimePickerDialog and show it
        val timePickerDialog = TimePickerDialog(
            requireContext(), { _, selectedHour, selectedMinute ->
                // Handle the selected time here
                viewModel.setMedicationTimes(
                    selectedHour, selectedMinute, timeIndex
                )


            }, hour, minute, false // true for 24-hour time, false for AM/PM
        )

        timePickerDialog.show()

    }

    private fun showDatePickerDialog() {
        val today = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog(
            requireContext(), { _, year, month, dayOfMonth ->
                // Handle the selected date here
                val selectedDate = String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth)
                // Create a SimpleDateFormat instance with the desired format
                val dateFormat =
                    SimpleDateFormat(Constants.YEAR_MONTH_DAY_FORMAT, Locale.getDefault())

                val durationFrom: Date? = dateFormat.parse(selectedDate)

                durationFrom?.let {

                    viewModel.setDurations(selectedDate = it)
                }

            }, today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)
        )

        // Set the minimum date to today
        datePickerDialog.datePicker.minDate = today.timeInMillis



        datePickerDialog.show()
    }

    private fun convertTo12HourFormat(time24: String): String {
        // Split the input into hours, minutes, and seconds
        val parts = time24.split(":")
        var hour = parts[0].toInt()
        val minutes = parts[1]

        // Determine AM or PM
        val period: String = if (hour >= 12) "PM" else "AM"

        // Convert hour from 24-hour to 12-hour format
        if (hour == 0) {
            hour = 12 // Midnight case (00:XX:XX becomes 12:XX AM)
        } else if (hour > 12) {
            hour -= 12 // Convert hours > 12 to 12-hour format
        }

        // Format the time in 12-hour format with AM/PM
        return "%02d:%s %s".format(hour, minutes, period)
    }

    private fun allTimesHaveAtLeastOneHourDifference(): Boolean {
        // Parse time strings into minutes since midnight
        val timeStrings = viewModel.currentMedicine?.time ?: emptyList()
        val timesInMinutes = timeStrings.map { timeToMinutes(it) }

        // Check if every pair of times has at least a 1-hour difference
        for (i in timesInMinutes.indices) {
            for (j in i + 1 until timesInMinutes.size) {
                val time1 = timesInMinutes[i]
                val time2 = timesInMinutes[j]
                val diffInMinutes = abs(time1 - time2)
                if (diffInMinutes < 60) {
                    showToast(
                        "${convertTo12HourFormat(timeStrings[i])} and ${
                            convertTo12HourFormat(
                                timeStrings[j]
                            )
                        } should have at least 1-hour difference"
                    )
                    return false
                }
            }
        }

        return true
    }

    private fun timeToMinutes(time: String): Int {
        val parts = time.split(":")
        val hours = parts[0].toInt()
        val minutes = parts[1].toInt()
        return hours * 60 + minutes
    }


    fun convertDateFormat(date: String): String {
        // Split the date into year, month, and day
        val parts = date.split("-")
        val year = parts[0]
        val month = parts[1]
        val day = parts[2]

        // Rearrange and return the date in DD-MM-YYYY format
        return "$day-$month-$year"
    }


    private fun activateOrUpdate(status: String) {
        if (allTimesHaveAtLeastOneHourDifference()) {
            viewModel.currentMedicine?.let { it1 ->
                viewModel.executeAction(
                    MedicineDetailsAction.UpdateMedicine(
                        it1.toUpdateRequest(status = status)
                    )
                )

            }
        }
    }
}
