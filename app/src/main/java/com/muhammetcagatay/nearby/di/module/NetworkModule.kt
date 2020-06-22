/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.muhammetcagatay.nearby.di.module

import com.muhammetcagatay.nearby.data.remote.NearByApiService
import com.muhammetcagatay.nearby.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

  fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .baseUrl(Constants.BASE_URL)
      .client(okHttpClient)
      .addConverterFactory(GsonConverterFactory.create()).build()
  }

  fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient()
      .newBuilder()
      .addInterceptor(loggingInterceptor)
      .build()
  }

  fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val logger = HttpLoggingInterceptor()
    logger.level = HttpLoggingInterceptor.Level.BODY
    return logger
  }



  fun provideNearByApi(retrofit: Retrofit): NearByApiService = retrofit.create(NearByApiService::class.java)

  factory { provideOkHttpClient(get()) }
  factory { provideNearByApi(get()) }
  factory { provideLoggingInterceptor() }
   single { provideRetrofit(get()) }

}
