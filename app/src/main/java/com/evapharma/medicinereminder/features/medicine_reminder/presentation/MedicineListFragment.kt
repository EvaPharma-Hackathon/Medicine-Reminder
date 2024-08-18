package com.evapharma.medicinereminder.features.medicine_reminder.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.evapharma.medicinereminder.databinding.FragmentMedicineListBinding
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.intents.MedicineListIntent
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.states.MedicineListState
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewmodels.MedicineListViewModel
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.adapters.MedicineListAdapter

class MedicineListFragment : Fragment() {

    private var _binding: FragmentMedicineListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MedicineListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMedicineListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MedicineListAdapter(emptyList()) { medicineId ->
            val action = MedicineListFragmentDirections.actionFirstFragmentToSecondFragment(medicineId)
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
                    val medicineList = state.medicineList
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
