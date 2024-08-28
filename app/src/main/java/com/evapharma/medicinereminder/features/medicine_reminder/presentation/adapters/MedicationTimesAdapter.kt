package com.evapharma.medicinereminder.features.medicine_reminder.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evapharma.medicinereminder.databinding.TimeViewBinding
import java.time.LocalTime
import java.time.format.DateTimeFormatter


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
            if (medicationTime.isEmpty()) "Unspecified" else convertTo12HourFormat(medicationTime)
        if (!isEditable) {
            holder.binding.editButton.visibility = View.GONE
        } else {
            holder.binding.editButton.text = if (medicationTime.isEmpty()) "Add" else "Edit"
            holder.binding.editButton.setOnClickListener {
                onEditTime(position)
            }
        }


    }


    private fun convertTo12HourFormat(time24: String): String {
        // Split the input into hours, minutes, and seconds
        val parts = time24.split(":")
        var hour = parts[0].toInt()
        val minutes = parts[1]
        val period: String

        // Determine AM or PM
        period = if (hour >= 12) "PM" else "AM"

        // Convert hour from 24-hour to 12-hour format
        if (hour == 0) {
            hour = 12 // Midnight case (00:XX:XX becomes 12:XX AM)
        } else if (hour > 12) {
            hour -= 12 // Convert hours > 12 to 12-hour format
        }

        // Format the time in 12-hour format with AM/PM
        return "%02d:%s %s".format(hour, minutes, period)
    }


    fun updateData(newMedicationTimes: List<String>, isEditable: Boolean) {
        medicationTimes = newMedicationTimes
        this.isEditable = isEditable

        notifyDataSetChanged()
    }
}


