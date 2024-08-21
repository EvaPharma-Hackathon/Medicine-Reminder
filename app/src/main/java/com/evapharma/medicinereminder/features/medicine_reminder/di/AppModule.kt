package com.evapharma.medicinereminder.di

import com.evapharma.medicinereminder.data.NotificationRepoImpl
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.MyFirebaseMessagingService
import com.evapharma.medicinereminder.features.medicine_reminder.data.repository.MedicineRepoImpl
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.MedicineApiService
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.MedicineRemoteDataSource
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.MedicineRemoteDataSourceImpl
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.NotificationApiService
import com.evapharma.medicinereminder.features.medicine_reminder.domain.repositry.MedicineRepo
import com.evapharma.medicinereminder.features.medicine_reminder.domain.repositry.NotificationRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    // Medicine


    @Binds
    abstract fun bindMedicineRepository(medicineRepoImpl: MedicineRepoImpl): MedicineRepo

    @Binds
    abstract fun bindMedicineRemoteDataSource(medicineRemoteDataSourceImpl: MedicineRemoteDataSourceImpl): MedicineRemoteDataSource


    // Notification


    @Provides
    @Singleton
    fun provideMyFirebaseMessagingService(): MyFirebaseMessagingService {
        return MyFirebaseMessagingService()
    }

    @Binds
    abstract fun bindNotificationRepository(notificationRepository: NotificationRepoImpl): NotificationRepo


}


@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

    // Medicine Api Service
    @Provides
    @Singleton
    fun provideMedicineApiService(retrofit: Retrofit): MedicineApiService {
        return retrofit.create(MedicineApiService::class.java)
    }

    // Notification Api Service

    @Provides
    @Singleton
    fun provideNotificationApiService(retrofit: Retrofit): NotificationApiService {
        return retrofit.create(NotificationApiService::class.java)
    }
}
