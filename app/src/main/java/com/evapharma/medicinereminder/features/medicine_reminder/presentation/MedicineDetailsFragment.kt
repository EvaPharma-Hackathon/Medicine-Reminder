package com.evapharma.medicinereminder.features.medicine_reminder.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evapharma.medicinereminder.databinding.FragmentMedicineDetailsBinding
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.FrequencyType
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.periodType
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.status


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
        /*
                val medicine = MedicineDetailsFragmentArgs.fromBundle(requireArguments()).medicine
        */
        val medicine: Medicine = Medicine(
            id = 2,
            name = "Ibuprofen",
            dosage = "200mg",
            titration = null,
            unit = "mg",
            direction = "Take one tablet after meals.",
            time = "18:00",
            durationFrom = "10/09/2023",
            durationTo = "15/09/2023",
            frequency = 2,
            isChronic = false,
            period = 10,
            status = status.INACTIVE,
            periodType = periodType.DAY,
            frequencyType = FrequencyType.DAILY
        )
        medicine.let {
            binding.medicineTitle.text = it.name
            binding.medicineDosage.text =
                if (it.dosage.isNullOrEmpty()) "${it.titration}+${it.unit}" else "${it.dosage}+${it.unit}"
            binding.medicineDirections.text = it.direction
            binding.medicineTime.text = it.time
            binding.medicineDuration.text = "${it.durationFrom} - ${it.durationTo}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}