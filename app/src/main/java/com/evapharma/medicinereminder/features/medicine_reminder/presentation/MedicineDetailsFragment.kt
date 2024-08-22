package com.evapharma.medicinereminder.features.medicine_reminder.presentation

import androidx.lifecycle.ViewModelProvider
import com.evapharma.medicinereminder.core.BaseFragment
import com.evapharma.medicinereminder.databinding.FragmentMedicineDetailsBinding
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.action.MedicineDetailsAction
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewmodel.MedicineDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MedicineDetailsFragment :
    BaseFragment<FragmentMedicineDetailsBinding, MedicineDetailsViewModel>() {
    override fun initBinding(): FragmentMedicineDetailsBinding {
        return FragmentMedicineDetailsBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this)[MedicineDetailsViewModel::class.java]
    }

    override fun onFragmentCreated() {

        val medicine = MedicineDetailsFragmentArgs.fromBundle(requireArguments()).medicine

        // Trigger the loading of the medicine
        viewModel.handleAction(MedicineDetailsAction.LoadMedicine(medicine = medicine))

//        // Set up the RecyclerView
//        val adapter = MedicineListAdapter(emptyList()) { selectedMedicine ->
//            val action =
//                MedicineListFragmentDirections.actionFirstFragmentToSecondFragment(medicine = selectedMedicine)
//            findNavController().navigate(action)
//        }
//
//        binding.medicineListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
//        binding.medicineListRecyclerView.adapter = adapter
//
//        lifecycleScope.launch {
//            viewModel.viewStates.collect { state ->
//
//                if (state.isLoading) {
//                    // Show loading indicator
//                } else if (state.isEmpty) {
//                    // Show empty state
//                } else if (state.isSuccess) {
//                    state.data?.let { medicine ->
//
//                    }
//                } else if (state.error != null) {
//                    // Show error state
//                }
//            }
//        }


    }

}
