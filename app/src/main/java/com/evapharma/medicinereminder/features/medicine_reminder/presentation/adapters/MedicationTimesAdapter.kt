package com.evapharma.medicinereminder.features.medicine_reminder.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evapharma.medicinereminder.databinding.TimeViewBinding


class MedicationTimesAdapter(
    private var medicationTimes: List<String>,
) : RecyclerView.Adapter<MedicationTimesAdapter.TimeViewHolder>() {

    private lateinit var onEditTime: (Int) -> Unit
    private var isEditable: Boolean = false


    fun setOnEditTime(onEditTime: (Int) -> Unit) {
        this.onEditTime = onEditTime
    }

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



        holder.binding.timeText.text =
            if (medicationTime.isEmpty()) "Unspecified" else medicationTime.dropLast(3)
        if (!isEditable) {
            holder.binding.editButton.visibility = View.GONE
        } else {
            holder.binding.editButton.text = if (medicationTime.isEmpty()) "Add" else "Edit"
            holder.binding.editButton.setOnClickListener {
                onEditTime(position)
            }
        }


    }


    fun updateData(newMedicationTimes: List<String>, isEditable: Boolean) {
        medicationTimes = newMedicationTimes
        this.isEditable = isEditable

        notifyDataSetChanged()
    }
}


