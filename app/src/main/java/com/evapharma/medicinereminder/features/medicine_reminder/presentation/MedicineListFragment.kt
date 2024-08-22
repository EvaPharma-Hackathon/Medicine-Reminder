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
import com.evapharma.medicinereminder.R
import com.evapharma.medicinereminder.core.BaseFragment
import com.evapharma.medicinereminder.databinding.FragmentMedicineListBinding
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.action.MedicineListAction
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.adapters.MedicineListAdapter
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewmodel.MedicineListViewModel
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


//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_medicine_list, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Ensure that the activity implements the callback
//        (activity as? MainActivity)?.setToolbarTitle("Medicines List")
//    }

    override fun onFragmentCreated() {
        // Trigger the loading of medicine list
        viewModel.handleAction(MedicineListAction.LoadMedicineList)

        // Set up the RecyclerView
        val adapter = MedicineListAdapter(emptyList()) { selectedMedicine ->
            val action =
                MedicineListFragmentDirections.actionFirstFragmentToSecondFragment(medicine = selectedMedicine)
            findNavController().navigate(action)
        }

        binding.medicineListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.medicineListRecyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.viewStates.collect { state ->

                if (state.isLoading) {
                    // Show loading indicator
                } else if (state.isEmpty) {
                    // Show empty state
                } else if (state.isSuccess) {
                    state.data?.let { medicineList ->
                        adapter.updateData(medicineList)
                    }
                } else if (state.error != null) {
                    // Show error state
                }
            }
        }


    }

}
