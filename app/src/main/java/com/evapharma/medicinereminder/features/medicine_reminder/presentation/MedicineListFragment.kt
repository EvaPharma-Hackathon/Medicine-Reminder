package com.evapharma.medicinereminder.features.medicine_reminder.presentation

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
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

        println("updateUI: $state")
        // Update the UI based on the state
        if (state.isLoading) {
            println("isLoading")
            binding.progressBar.visibility = View.VISIBLE
            binding.nestedScrollView.visibility = View.GONE
            // Show loading indicator
        } else if (state.isSuccess) {
            println("Success")
            binding.progressBar.visibility = View.GONE
            binding.nestedScrollView.visibility = View.VISIBLE
            // Update the RecyclerView with the new data
            state.data?.let {
                println("data $it")
                (binding.medicineListRecyclerView.adapter as? MedicineListAdapter)?.updateData(
                    it
                )
            }
        } else if (state.isEmpty) {
            binding.progressBar.visibility = View.GONE
            binding.nestedScrollView.visibility = View.VISIBLE
            println("isEmpty")
            // Show empty state UI
        } else if (state.error != null) {
            binding.progressBar.visibility = View.GONE
            binding.nestedScrollView.visibility = View.VISIBLE
            println("error")
            // Show error message
        }
    }

}
