package com.evapharma.medicinereminder.features.medicine_reminder.data.repository

import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine

class MedicineRepository {
    fun getMedicineList(): List<Medicine> {
        return listOf(
            Medicine(1, "Medicine 1", "Dosage 1", "instruction 1","time 1","Date from 1","Date from 1"),
            Medicine(2, "Medicine 2", "Dosage 2", "instruction 2","time 2","Date from 2","Date from 2"),
            Medicine(3, "Medicine 3", "Dosage 3", "instruction 3","time 3","Date from 3","Date from 3")
        )

    }
}