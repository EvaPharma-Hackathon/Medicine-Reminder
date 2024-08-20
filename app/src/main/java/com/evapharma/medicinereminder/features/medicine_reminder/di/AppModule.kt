package com.evapharma.medicinereminder.di

import com.evapharma.medicinereminder.data.NotificationRepository
import com.evapharma.medicinereminder.data.source.remote.MyFirebaseMessagingService
import com.evapharma.medicinereminder.domain.GetNotificationsUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.data.repository.MedicineRepository
import com.evapharma.medicinereminder.features.medicine_reminder.data.source.remote.MedicineApiService
import com.evapharma.medicinereminder.features.medicine_reminder.data.source.remote.NotificationApiService
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.GetMedicineListUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.UpdateMedicineStatusUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.UpdateMedicineUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://medicinereminder.evapharma.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMedicineApiService(retrofit: Retrofit): MedicineApiService {
        return retrofit.create(MedicineApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideNotificationApiService(retrofit: Retrofit): NotificationApiService {
        return retrofit.create(NotificationApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMyFirebaseMessagingService(): MyFirebaseMessagingService {
        return MyFirebaseMessagingService()
    }

    @Provides
    @Singleton
    fun provideNotificationRepository(
        firebaseMessagingService: MyFirebaseMessagingService,
        postToken: NotificationApiService
    ): NotificationRepository {
        return NotificationRepository(firebaseMessagingService, postToken)
    }

    @Provides
    @Singleton
    fun provideGetNotificationsUseCase(
        repository: NotificationRepository
    ): GetNotificationsUseCase {
        return GetNotificationsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideMedicineRepository(apiService: MedicineApiService): MedicineRepository {
        return MedicineRepository(apiService)
    }

    @Provides
    @Singleton
    fun provideGetMedicineListUseCase(
        repository: MedicineRepository
    ): GetMedicineListUseCase {
        return GetMedicineListUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideUpdateMedicineUseCase(
        repository: MedicineRepository
    ): UpdateMedicineUseCase {
        return UpdateMedicineUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideUpdateMedicineStatusUseCase(
        repository: MedicineRepository
    ): UpdateMedicineStatusUseCase {
        return UpdateMedicineStatusUseCase(repository)
    }
}
