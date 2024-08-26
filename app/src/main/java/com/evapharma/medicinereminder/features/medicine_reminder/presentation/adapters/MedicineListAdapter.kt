package com.evapharma.medicinereminder.features.medicine_reminder.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.evapharma.medicinereminder.databinding.MedicineCardBinding
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.getStatus


class MedicineListAdapter(
    private var medicineList: List<Medicine>,
    private val onItemClick: (medicineId: String) -> Unit
) : RecyclerView.Adapter<MedicineListAdapter.MedicineViewHolder>() {

    inner class MedicineViewHolder(val binding: MedicineCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val selectedMedicine = medicineList[position]
                    onItemClick(selectedMedicine.id.toString())
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
        holder.binding.statusText.text = medicine.getStatus().apiName

        medicine.getStatus().color.let { color ->
            holder.binding.statusText.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context, color
                )
            )
        }


    }


    fun updateData(newMedicineList: List<Medicine>) {
        medicineList = newMedicineList
        notifyDataSetChanged()
    }
}


