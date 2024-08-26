package com.evapharma.medicinereminder.features.medicine_reminder.presentation

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

        binding.topBar.leftIcon.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.topBar.title.text = getString(R.string.my_medications)


    }

    override fun onResume() {
        // Trigger the loading of medicine list
        println("onResume in MedicineListFragment")
        super.onResume()
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

            (activity as? MainActivity)?.showEmptyView()

        } else if (state.error != null) {
            (activity as? MainActivity)?.showMainContent()
        }
    }

}
