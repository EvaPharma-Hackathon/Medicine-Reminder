package com.evapharma.medicinereminder.features.medicine_reminder.presentation

import MedicineListViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.evapharma.medicinereminder.core.BaseFragment
import com.evapharma.medicinereminder.databinding.FragmentMedicineListBinding
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.intents.MedicineListIntent
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.states.MedicineListState
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.adapters.MedicineListAdapter

class MedicineListFragment : BaseFragment<FragmentMedicineListBinding, MedicineListViewModel>() {
    override fun initBinding(): FragmentMedicineListBinding {
        return FragmentMedicineListBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this)[MedicineListViewModel::class.java]
    }

    override fun onFragmentCreated() {
        val adapter = MedicineListAdapter(emptyList()) { selectedMedicine ->
            val action =
                MedicineListFragmentDirections.actionFirstFragmentToSecondFragment(/*selectedMedicine*/)
            findNavController().navigate(action)
        }

        binding.medicineListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.medicineListRecyclerView.adapter = adapter

        viewModel.medicineListState.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is MedicineListState.Loading -> {
                    // Show loading indicator
                }

                is MedicineListState.Success -> {
                    val medicineList = state.medicineList.collect(

                    )
                    adapter.updateData(medicineList)
                }

                is MedicineListState.Error -> {
                    // Show error message
                }
            }
        })

        // Trigger the loading of medicine list
        viewModel.handleIntent(MedicineListIntent.LoadMedicineList)
    }

}
