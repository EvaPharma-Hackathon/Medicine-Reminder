package com.evapharma.medicinereminder.features.medicine_reminder.presentation

import android.app.AlertDialog
import android.view.ContextThemeWrapper
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.evapharma.medicinereminder.MainActivity
import com.evapharma.medicinereminder.R
import com.evapharma.medicinereminder.core.BaseFragment
import com.evapharma.medicinereminder.databinding.FragmentMedicineListBinding
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Status
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.getStatus
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.action.MedicineListAction
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.adapters.MedicineListAdapter
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewmodel.MedicineListViewModel
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.MedicineListViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MedicineListFragment : BaseFragment<FragmentMedicineListBinding, MedicineListViewModel>() {


    override fun initBinding(): FragmentMedicineListBinding {
        return FragmentMedicineListBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this)[MedicineListViewModel::class.java]
    }

    override fun onFragmentCreated() {

        // set tryAgain Default Action
        (activity as? MainActivity)?.setTryAgainListener {
            viewModel.executeAction(MedicineListAction.LoadMedicineList)
        }

        // Set up the RecyclerView
        val adapter = MedicineListAdapter(emptyList()) { selectedMedicineId ->
            val action =
                MedicineListFragmentDirections.actionFirstFragmentToSecondFragment(medicineId = selectedMedicineId)
            findNavController().navigate(action)
        }



        binding.medicineListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.medicineListRecyclerView.adapter = adapter

//        binding.topBar.leftIcon.setOnClickListener {
//            findNavController().navigateUp()
//        }

        binding.topBar.title.text = getString(R.string.my_medications)


    }

    override fun onResume() {
        // Trigger the loading of medicine list
        super.onResume()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.viewStates.collect { state ->
                // Handle the state update here
                updateUI(state)
            }
        }



        (binding.medicineListRecyclerView.adapter as? MedicineListAdapter)?.setOnLongPress { medicine, currentView ->
            // Create a PopupMenu programmatically
            when (medicine.getStatus()) {

                Status.ACTIVE -> {


                    val wrapper = ContextThemeWrapper(requireContext(), R.style.CustomPopupMenu)
                    val popupMenu = PopupMenu(wrapper, currentView)

                    // Add Options
                    popupMenu.menu.add(0, 1, 0, getString(R.string.snooze_medication_reminder))

                    popupMenu.menu.add(0, 2, 1, "Stop")

                    // Handle menu item clicks
                    popupMenu.setOnMenuItemClickListener { menuItem: MenuItem ->
                        when (menuItem.title) {
                            getString(R.string.snooze_medication_reminder) -> {
                                showConfirmationDialog(message = getString(R.string.are_you_sure_you_want_to_snooze_this_medication)) {
                                    medicine.id?.let {
                                        viewModel.executeAction(
                                            MedicineListAction.UpdateMedicineStatus(

                                                MedicineStatusUpdateRequest(
                                                    medicationId = it,
                                                    status = Status.SNOOZED.apiName
                                                ),
                                                showToast = { message ->
                                                    showToast(message)
                                                }

                                            )
                                        )
                                    }
                                }
                                true
                            }

                            "Stop" -> {
                                if (medicine.isChronic == false) {


                                    showConfirmationDialog(message = getString(R.string.are_you_sure_you_want_to_stop_this_medication)) {
                                        medicine.id?.let {
                                            viewModel.executeAction(
                                                MedicineListAction.UpdateMedicineStatus(
                                                    MedicineStatusUpdateRequest(
                                                        medicationId = it,
                                                        status = Status.STOPPED.apiName
                                                    ),
                                                    showToast = { message ->
                                                        showToast(message)
                                                    }
                                                )
                                            )
                                        }
                                    }
                                } else {
                                    showToast(getString(R.string.this_is_a_medication_to_a_chronic_disease_so_it_can_t_be_stopped))
                                }
                                true
                            }

                            else -> false
                        }
                    }

                    // Show the PopupMenu
                    popupMenu.show()
                }

                Status.SNOOZED -> {

                    val wrapper = ContextThemeWrapper(requireContext(), R.style.CustomPopupMenu)
                    val popupMenu = PopupMenu(wrapper, currentView)

                    // Add Options
                    popupMenu.menu.add(0, 1, 0, "Stop")

                    // Handle menu item clicks
                    popupMenu.setOnMenuItemClickListener { menuItem: MenuItem ->
                        when (menuItem.title) {
                            "Stop" -> {
                                if (medicine.isChronic == false) {
                                    showConfirmationDialog(message = getString(R.string.are_you_sure_you_want_to_stop_this_medication)) {
                                        medicine.id?.let {
                                            viewModel.executeAction(
                                                MedicineListAction.UpdateMedicineStatus(
                                                    MedicineStatusUpdateRequest(
                                                        medicationId = it,
                                                        status = Status.STOPPED.apiName
                                                    ),
                                                    showToast = { message ->
                                                        showToast(message)
                                                    }
                                                )
                                            )
                                        }
                                    }
                                } else {
                                    showToast(getString(R.string.this_is_a_medication_to_a_chronic_disease_so_it_can_t_be_stopped))
                                }
                                true
                            }

                            else -> false
                        }
                    }

                    // Show the PopupMenu
                    popupMenu.show()

                }

                else -> {}
            }


        }

        // Trigger the loading of medicine list
        viewModel.executeAction(MedicineListAction.LoadMedicineList)

    }


    private fun updateUI(state: MedicineListViewState) {


        // Update the UI based on the state
        if (state.isLoading) {
            (activity as? MainActivity)?.showLoadingSpinner()

        } else if (state.isSuccess) {
            (activity as? MainActivity)?.showMainContent()
            state.data?.let {

                (binding.medicineListRecyclerView.adapter as? MedicineListAdapter)?.updateData(
                    it
                )
            }
        } else if (state.isEmpty) {

            (activity as? MainActivity)?.showEmptyView(text = getString(R.string.no_medicines_found))

        } else if (state.error != null) {
            (activity as? MainActivity)?.showErrorView()
        }
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

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

}
