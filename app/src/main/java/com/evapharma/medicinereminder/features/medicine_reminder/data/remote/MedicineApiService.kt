package com.evapharma.medicinereminder.features.medicine_reminder.data.remote

import com.evapharma.medicinereminder.Endpoints
import com.evapharma.medicinereminder.core.models.BaseResponse
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface MedicineApiService {

    @GET(Endpoints.MEDICINE_LIST)
    suspend fun getMedicineList(): Response<BaseResponse<List<Medicine>>>


    @POST(Endpoints.SET_REMINDER)
    suspend fun setReminder(
        @Body medicineUpdateRequest: MedicineUpdateRequest
    ): Response<BaseResponse<Any>>


    @PUT(Endpoints.UPDATE_STATUS)
    suspend fun updateStatus(
        @Body request: MedicineStatusUpdateRequest
    ): Response<BaseResponse<Any>>

}

