package com.evapharma.medicinereminder.core.network

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.evapharma.medicinereminder.core.utils.Constants
import com.evapharma.medicinereminder.core.utils.StringLocale
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class BaseURLFactory {

    companion object {

        val gson = GsonBuilder().setLenient().create()

        var retrofit: Retrofit = provideRetrofit()

        fun resetBaseURL(url: String) {
            retrofit = Retrofit.Builder()
                .baseUrl(url)
                .client(provideOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }


        fun provideRetrofit(timeout: Long = 30): Retrofit =
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(provideOkHttpClient(timeout))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()


        private fun provideOkHttpClient(timeout: Long = 30): OkHttpClient {
            val chuckerInterceptor =
                ChuckerInterceptor.Builder(StringLocale.instance.appContextProvider.getAppContext())
                    .build()
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .addInterceptor(chuckerInterceptor)

            return okHttpClient.build()
        }


        fun provideRetrofitWithAuth(
            timeout: Long = 30,
            bearerToken: String,
            baseUrl: String
        ): Retrofit {


            val chuckerInterceptor =
                ChuckerInterceptor.Builder(StringLocale.instance.appContextProvider.getAppContext())
                    .build()
            val authInterceptor = Interceptor { chain ->
                val originalRequest = chain.request()
                val requestWithToken = originalRequest.newBuilder()
                    .header("Authorization", "Bearer $bearerToken")
                    .build()
                chain.proceed(requestWithToken)
            }
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .addInterceptor(authInterceptor)
                .addInterceptor(chuckerInterceptor).build()


            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(provideOkHttpClient(timeout))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }


    }

}

