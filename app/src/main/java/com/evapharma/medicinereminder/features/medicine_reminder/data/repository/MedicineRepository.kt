package com.evapharma.medicinereminder.features.medicine_reminder.data.repository

import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.frequencyType
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.periodType
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.status
import java.time.LocalTime


class MedicineRepository {

    fun getMedicineList(): List<Medicine> {
        // Mocked data. Replace with actual API or database calls
        return listOf(
            Medicine(
                id = 1,
                name = "Paracetamol",
                dosage = "500mg",
                titration = null,
                unit = "mg",
                directions = "Take one tablet every 6 hours.",
                time = "12:00",
                durationFrom = "10/09/2023",
                durationTo = "15/09/2023",
                frequency = 3,
                isChronic = false,
                period = 7,
                status = status.ACTIVE,
                periodType = periodType.DAY,
                frequencyType = frequencyType.DAILY
            ),
            Medicine(
                id = 2,
                name = "Ibuprofen",
                dosage = "200mg",
                titration = null,
                unit = "mg",
                directions = "Take one tablet after meals.",
                time = "18:00",
                durationFrom ="10/09/2023",
                durationTo ="15/09/2023",
                frequency = 2,
                isChronic = false,
                period = 10,
                status = status.INACTIVE,
                periodType = periodType.DAY,
                frequencyType = frequencyType.DAILY
            )
        )
    }
}
