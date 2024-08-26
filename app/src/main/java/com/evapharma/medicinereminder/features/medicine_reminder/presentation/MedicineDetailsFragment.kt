package com.evapharma.medicinereminder.features.medicine_reminder.presentation

import android.app.AlertDialog
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
import com.evapharma.medicinereminder.R
import com.evapharma.medicinereminder.core.BaseFragment
import com.evapharma.medicinereminder.databinding.FragmentMedicineDetailsBinding
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Status
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.getStatus
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.action.MedicineDetailsAction
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.adapters.MedicationTimesAdapter
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewmodel.MedicineDetailsViewModel
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.MedicineDetailsViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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


    }


    override fun onResume() {
        super.onResume()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.viewStates.collect { state ->
                // Handle the state update here
                updateUI(state)
            }
        }


        // Trigger the loading of medicine list
        viewModel.executeAction(
            MedicineDetailsAction.LoadMedicine(
                medicineId = medicineId?.toInt() ?: 0
            )
        )
    }

    private fun showLoadingSpinner() {
        // Show loading indicator
        binding.progressBar.visibility = View.VISIBLE
        binding.nestedScrollView.visibility = View.GONE

    }

    private fun hideLoadingSpinner() {
        // Hide loading indicator
        binding.progressBar.visibility = View.GONE
        binding.nestedScrollView.visibility = View.VISIBLE
    }


    private fun updateUI(state: MedicineDetailsViewState) {
        // Update the UI based on the state

        val medicineState = state.medicationViewState
        val medicineUpdateState = state.medicineUpdateViewState
        if (medicineState?.isLoading == true || medicineUpdateState?.isLoading == true) {
            showLoadingSpinner()

        } else {
            medicineState?.let { medState ->

                if (medState.isSuccess) {

                    hideLoadingSpinner()

                    medState.data?.let {
                        binding.title.text = it.name
                        binding.status.text = it.getStatus().apiName
                        binding.status.setTextColor(
                            ContextCompat.getColor(
                                requireContext(), it.getStatus().color
                            )
                        )

                        if (it.dosage == null) {

                            binding.MedicineDetailsDosage.root.visibility = View.GONE
                        } else {
                            binding.MedicineDetailsDosage.title.text = getString(R.string.dosage)
                            binding.MedicineDetailsDosage.details.text = it.dosage.toString()
                        }

                        if (it.durationFrom.isNullOrBlank() || it.durationTo.isNullOrBlank()) {
                            binding.MedicineCardDuration.root.visibility = View.GONE
                        } else {
                            binding.MedicineCardDuration.root.visibility = View.VISIBLE
                            binding.MedicineCardDuration.DurationFrom.text = it.durationFrom
                            binding.MedicineCardDuration.DurationTo.text = it.durationTo
                        }

                        if (it.time.isNullOrEmpty()) {
                            binding.MedicationTimes.root.visibility = View.GONE
                        } else {
                            binding.MedicationTimes.root.visibility = View.VISIBLE
                            (binding.MedicationTimes.medicationsTimesRecyclerView.adapter as MedicationTimesAdapter).updateData(
                                newMedicationTimes = it.time ?: emptyList()
                            )
                        }

                        // buttons to show
                        when (it.getStatus()) {
                            Status.ACTIVE -> {
                                binding.statusInverterBtn.visibility = View.VISIBLE
                                binding.statusInverterBtn.text = getString(R.string.snooze_medication_reminder)
                                binding.statusInverterBtn.setBackgroundColor(
                                    ContextCompat.getColor(
                                        requireContext(), R.color.primary_variant
                                    )
                                )
                                binding.statusInverterBtn.setOnClickListener {

                                    showConfirmationDialog(
                                        message = getString(R.string.are_you_sure_you_want_to_snooze_this_medication),
                                        performAction = {
                                            viewModel.executeAction(
                                                MedicineDetailsAction.UpdateMedicineStatus(
                                                    MedicineStatusUpdateRequest(
                                                        medicationId = medicineId?.toInt() ?: 0,
                                                        status = Status.SNOOZED.apiName
                                                    )
                                                )
                                            )
                                        }
                                    )
                                }

                                if (it.isChronic == true) {
                                    binding.stopMedicationBtn.visibility = View.GONE
                                    binding.isChronicWarningMessage.visibility = View.VISIBLE
                                } else {
                                    binding.stopMedicationBtn.visibility = View.VISIBLE
                                    binding.isChronicWarningMessage.visibility = View.GONE
                                    binding.stopMedicationBtn.text = getString(R.string.stop_medication)
                                    binding.stopMedicationBtn.setBackgroundColor(
                                        ContextCompat.getColor(
                                            requireContext(), R.color.error
                                        )
                                    )
                                    binding.stopMedicationBtn.setOnClickListener {
                                        showConfirmationDialog(
                                            message = getString(R.string.are_you_sure_you_want_to_stop_this_medication),
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
                                            }
                                        )
                                    }
                                }

                            }

                            Status.INACTIVE -> {
                                binding.isChronicWarningMessage.visibility = View.GONE
                                binding.stopMedicationBtn.visibility = View.GONE

                                binding.statusInverterBtn.visibility = View.VISIBLE
                                binding.statusInverterBtn.text =
                                    getString(R.string.set_medication_time)
                                binding.statusInverterBtn.setBackgroundColor(
                                    ContextCompat.getColor(
                                        requireContext(), R.color.primary_variant
                                    )
                                )
                                binding.statusInverterBtn.setOnClickListener {
                                    showTimePickerDialog()
                                }


                            }

                            Status.SNOOZED -> {
                                binding.statusInverterBtn.visibility = View.GONE

                                if (it.isChronic == true) {
                                    binding.stopMedicationBtn.visibility = View.GONE
                                    binding.isChronicWarningMessage.visibility = View.VISIBLE
                                } else {
                                    binding.stopMedicationBtn.visibility = View.VISIBLE
                                    binding.isChronicWarningMessage.visibility = View.GONE
                                    binding.stopMedicationBtn.setOnClickListener {
                                        showConfirmationDialog(
                                            message = getString(R.string.are_you_sure_you_want_to_stop_this_medication),
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
                                            }
                                        )
                                    }
                                }
                            }

                            else -> {}
                        }
                    }
                } else if (medState.isEmpty) {
                    hideLoadingSpinner()
                    // Show empty state UI
                } else if (medState.error != null) {
                    hideLoadingSpinner()
                } else {
                }
            }

            medicineUpdateState?.let { medUpdateStatus ->
                if (medUpdateStatus.isSuccess) {
                    hideLoadingSpinner()
                    // show toast
                    showToast(getString(R.string.medicine_updated_successfully))
                    viewModel.executeAction(
                        MedicineDetailsAction.LoadMedicine(
                            medicineId = medicineId?.toInt() ?: 0
                        )
                    )

                } else if (medUpdateStatus.error != null) {
                    hideLoadingSpinner()
                    // show error toast
                    showToast(getString(R.string.error_updating_medicine_status))

                } else {
                }

            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun setActivateButtonData(
        durationFrom: String, durationTo: String, medicationTimes: List<String>
    ) {

        binding.stopMedicationBtn.text = getString(R.string.activate)

        binding.stopMedicationBtn.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(), R.color.success
            )
        )
        binding.stopMedicationBtn.isEnabled = true
        binding.stopMedicationBtn.setOnClickListener {
            viewModel.executeAction(
                MedicineDetailsAction.UpdateMedicine(
                    MedicineUpdateRequest(
                        medicationId = medicineId?.toInt() ?: 0,
                        status = Status.ACTIVE.apiName,
                        durationFrom = durationFrom,
                        durationTo = durationTo,
                        time = medicationTimes
                    )
                )
            )
        }
        binding.stopMedicationBtn.visibility = View.VISIBLE
    }


    private fun showConfirmationDialog(
        message: String = getString(R.string.are_you_sure),
        performAction: () -> Unit
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


    private fun showTimePickerDialog() {
        // Get the current time as default values
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        // Create a TimePickerDialog and show it
        val timePickerDialog = TimePickerDialog(
            requireContext(),
            { _, selectedHour, selectedMinute ->
                // Handle the selected time here
                viewModel.setMedicationTimes(
                    selectedHour,
                    selectedMinute,
                    viewSelections = { durationFrom, durationTo, newMedicationTimes ->
                        showDurationCard(durationFrom = durationFrom, durationTo = durationTo)
                        showMedicationTimes(newMedicationTimes = newMedicationTimes)
                        setActivateButtonData(
                            durationFrom = durationFrom,
                            durationTo = durationTo,
                            medicationTimes = newMedicationTimes
                        )
                    })


            },
            hour, minute, true // true for 24-hour time, false for AM/PM
        )

        timePickerDialog.show()

    }


    private fun showDurationCard(durationFrom: String, durationTo: String) {
        binding.MedicineCardDuration.root.visibility = View.VISIBLE
        binding.MedicineCardDuration.DurationFrom.text = durationFrom
        binding.MedicineCardDuration.DurationTo.text = durationTo
    }

    private fun showMedicationTimes(newMedicationTimes: List<String>) {
        (binding.MedicationTimes.medicationsTimesRecyclerView.adapter as MedicationTimesAdapter).updateData(
            newMedicationTimes = newMedicationTimes
        )
        binding.MedicationTimes.root.visibility = View.VISIBLE
    }
}
