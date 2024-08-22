package com.evapharma.medicinereminder.features.medicine_reminder.data.repo

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.FrequencyType
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.PeriodType
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Status
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.MedicineRemoteDataSource
import com.evapharma.medicinereminder.features.medicine_reminder.domain.repo.MedicineRepo
import javax.inject.Inject

class MedicineRepoImpl @Inject constructor(
    private val medicineRemoteDataSource: MedicineRemoteDataSource
) : MedicineRepo {

    override suspend fun getMedicineList(): DataState<List<Medicine>> =
//        medicineRemoteDataSource.getMedicineList()
        DataState.Success(
            listOf(
                Medicine(
                    id = 1,
                    name = "Medicine 1",
                    status = Status.ACTIVE,
                    time = listOf("", ""),
                    direction = "",
                    isChronic = false,
                    dosage = "10 mg",
                    durationFrom = "10",
                    durationTo = "20",
                    periodType = PeriodType.DAY,
                    frequencyType = FrequencyType.WEEKLY,
                    frequency = 1,
                    unit = "mg",
                    titration = "10",
                    period = 10,
                ),
                Medicine(
                    id = 2,
                    name = "Medicine 2",
                    status = Status.INACTIVE,
                    time = listOf("", ""),
                    direction = "",
                    isChronic = false,
                    dosage = "10 mg",
                    durationFrom = "10",
                    durationTo = "20",
                    periodType = PeriodType.DAY,
                    frequencyType = FrequencyType.WEEKLY,
                    frequency = 1,
                    unit = "mg",
                    titration = "10",
                    period = 10,
                ),
                Medicine(
                    id = 3,
                    name = "Medicine 3",
                    status = Status.STOPPED,
                    time = listOf("", ""),
                    direction = "",
                    isChronic = false,
                    dosage = "10 mg",
                    durationFrom = "10",
                    durationTo = "20",
                    periodType = PeriodType.DAY,
                    frequencyType = FrequencyType.WEEKLY,
                    frequency = 1,
                    unit = "mg",
                    titration = "10",
                    period = 10,
                )
            )
        )


    override suspend fun updateMedicine(medicineUpdateRequest: MedicineUpdateRequest): DataState<Void> =
        medicineRemoteDataSource.updateMedicine(medicineUpdateRequest)

    override suspend fun updateStatus(medicineStatusUpdateRequest: MedicineStatusUpdateRequest): DataState<Void> =
        medicineRemoteDataSource.updateStatus(medicineStatusUpdateRequest)
}
