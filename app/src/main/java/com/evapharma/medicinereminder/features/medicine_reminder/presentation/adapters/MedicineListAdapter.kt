package com.evapharma.medicinereminder.features.medicine_reminder.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evapharma.medicinereminder.databinding.ItemMedicineBinding
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine

class MedicineListAdapter(private var medicineList: List<Medicine>, private val onItemClick: (Int) -> Unit) :
    RecyclerView.Adapter<MedicineListAdapter.MedicineViewHolder>() {

    inner class MedicineViewHolder(val binding: ItemMedicineBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val medicineId = medicineList[position].id
                    onItemClick(medicineId)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        val binding = ItemMedicineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MedicineViewHolder(binding)
    }

    override fun getItemCount(): Int = medicineList.size

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        val medicine = medicineList[position]
        holder.binding.medicineTitle.text = medicine.title
    }

    fun updateData(newMedicineList: List<Medicine>) {
        medicineList = newMedicineList
        notifyDataSetChanged()
    }
}