
package com.muhammetcagatay.nearby.di.module
import com.muhammetcagatay.nearby.data.repository.NearByRetrofitRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

  single { NearByRetrofitRepositoryImpl(get()) }

}
