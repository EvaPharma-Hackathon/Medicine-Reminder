package com.evapharma.medicinereminder.features.medicine_reminder.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.evapharma.medicinereminder.R
import com.evapharma.medicinereminder.databinding.MedicineCardBinding
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Status


class MedicineListAdapter(
    private var medicineList: List<Medicine>,
    private val onItemClick: (medicine: Medicine) -> Unit
) : RecyclerView.Adapter<MedicineListAdapter.MedicineViewHolder>() {

    inner class MedicineViewHolder(val binding: MedicineCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val selectedMedicine = medicineList[position]
                    onItemClick(selectedMedicine)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        val binding =
            MedicineCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MedicineViewHolder(binding)
    }

    override fun getItemCount(): Int = medicineList.size

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        val medicine = medicineList[position]

        holder.binding.titleText.text = medicine.name
        holder.binding.statusText.text = medicine.status?.apiName
        holder.binding.statusText.setTextColor(
            ContextCompat.getColor(
                holder.itemView.context,
                when (medicine.status) {
                    Status.ACTIVE -> R.color.success
                    Status.INACTIVE -> R.color.black
                    Status.SNOOZED -> R.color.primary_color
                    Status.EXPIRED -> R.color.hint
                    else -> R.color.error
                }
            )
        )

    }


    fun updateData(newMedicineList: List<Medicine>) {
        medicineList = newMedicineList

        notifyDataSetChanged() // Notify RecyclerView of the data change


    }
}

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val titleTextView: TextView = view.findViewById(R.id.title_text)
    val statusTextView: TextView = view.findViewById(R.id.status_text)
}


