package com.evapharma.medicinereminder.features.medicine_reminder.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.evapharma.medicinereminder.MainActivity
import com.evapharma.medicinereminder.core.BaseFragment
import com.evapharma.medicinereminder.databinding.FragmentMedicineListBinding
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ensure that the activity implements the callback
        (activity as? MainActivity)?.setToolbarTitle("My Medications")



    }

    override fun onFragmentCreated() {

        // Set up the RecyclerView
        val adapter = MedicineListAdapter(emptyList()) { selectedMedicine ->
            val action =
                MedicineListFragmentDirections.actionFirstFragmentToSecondFragment(medicine = selectedMedicine)
            findNavController().navigate(action)
        }

        binding.medicineListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.medicineListRecyclerView.adapter = adapter





        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.viewStates.collect { state ->
                // Handle the state update here
                updateUI(state)
            }
        }


        // Trigger the loading of medicine list
        viewModel.executeAction(MedicineListAction.LoadMedicineList)


    }


    private fun updateUI(state: MedicineListViewState) {

        println("updateUI: $state")
        // Update the UI based on the state
        if (state.isLoading) {
            println("isLoading")
            // Show loading indicator
        } else if (state.isSuccess) {
            println("Success")
            // Update the RecyclerView with the new data
            state.data?.let {
                println("data ${it}")
                (binding.medicineListRecyclerView.adapter as? MedicineListAdapter)?.updateData(
                    it
                )
            }
        } else if (state.isEmpty) {
            println("isEmpty")
            // Show empty state UI
        } else if (state.error != null) {
            println("error")
            // Show error message
        }
    }

}
