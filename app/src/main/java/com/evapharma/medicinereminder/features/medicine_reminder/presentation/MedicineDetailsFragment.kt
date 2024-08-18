package com.evapharma.medicinereminder.features.medicine_reminder.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.evapharma.medicinereminder.R
import com.evapharma.medicinereminder.core.BaseFragment
import com.evapharma.medicinereminder.databinding.FragmentMedicineDetailsBinding
import com.evapharma.medicinereminder.features.covid_cases.presentation.viewmodels.MainViewModel
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine


class MedicineDetailsFragment : Fragment() {
    private var _binding: FragmentMedicineDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMedicineDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve Medicine object from arguments
        val medicine = arguments?.getParcelable<Medicine>("medicine")

        medicine?.let {
            binding.medicineTitle.text = it.title
            binding.medicineDosage.text = it.dosage
            binding.medicineDirections.text = it.instructions
            binding.medicineTime.text = it.time
            binding.medicineDuration.text = "${it.durationFrom} - ${it.durationTo}"
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}