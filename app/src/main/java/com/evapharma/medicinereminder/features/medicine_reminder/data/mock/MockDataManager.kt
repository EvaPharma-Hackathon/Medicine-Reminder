package com.evapharma.medicinereminder.features.medicine_reminder.data.mock

import com.evapharma.medicinereminder.features.medicine_reminder.data.model.FrequencyType
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.PeriodType
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Status

object MockDataManager {

    //-------------------------------------------- Mock data -------------------------------------------//
    // TODO: should be removed later

    var medicinesList =
        listOf(
            Medicine(
                id = 1,
                name = "Medicine 1",
                status = Status.ACTIVE,
                time = listOf("15:00", "22:00"),
                direction = "",
                isChronic = false,
                dosage = "10 mg",
                durationFrom = "10",
                durationTo = "20",
                periodType = PeriodType.DAY,
                frequencyType = FrequencyType.DAILY,
                frequency = 2,
                unit = "mg",
                titration = null,
                period = 15,
            ),
            Medicine(
                id = 2,
                name = "Medicine 2",
                status = Status.INACTIVE,
                time = emptyList(),
                direction = "",
                isChronic = false,
                dosage = "10 mg",
                durationFrom = "",
                durationTo = "",
                periodType = PeriodType.DAY,
                frequencyType = FrequencyType.WEEKLY,
                frequency = 1,
                unit = "mg",
                titration = "",
                period = 18,
            ),
            Medicine(
                id = 3,
                name = "Medicine 3",
                status = Status.SNOOZED,
                time = listOf("17:00"),
                direction = "",
                isChronic = true,
                dosage = "10 mg",
                durationFrom = "10",
                durationTo = "20",
                periodType = PeriodType.DAY,
                frequencyType = FrequencyType.WEEKLY,
                frequency = 1,
                unit = "mg",
                titration = "",
                period = 10,
            )
        )

    ///-------------------------------------------------------------------------------------------------------
}