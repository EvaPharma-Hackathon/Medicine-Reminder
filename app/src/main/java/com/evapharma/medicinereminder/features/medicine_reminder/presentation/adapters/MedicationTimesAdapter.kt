package com.evapharma.medicinereminder.features.medicine_reminder.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evapharma.medicinereminder.databinding.TimeViewBinding


class MedicationTimesAdapter(
    private var medicationTimes: List<String>,
) : RecyclerView.Adapter<MedicationTimesAdapter.TimeViewHolder>() {

    inner class TimeViewHolder(val binding: TimeViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeViewHolder {
        val binding =
            TimeViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TimeViewHolder(binding)
    }

    override fun getItemCount(): Int = medicationTimes.size

    override fun onBindViewHolder(holder: TimeViewHolder, position: Int) {
        val medicationTime = medicationTimes[position]

        holder.binding.timeText.text = medicationTime
    }


    fun updateData(newMedicationTimes: List<String>) {
        medicationTimes = newMedicationTimes
        notifyDataSetChanged()
    }
}


