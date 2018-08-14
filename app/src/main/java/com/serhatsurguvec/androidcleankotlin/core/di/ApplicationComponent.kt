package com.serhatsurguvec.androidcleankotlin.core.di

import com.serhatsurguvec.androidcleankotlin.AndroidApplication
import com.serhatsurguvec.androidcleankotlin.core.di.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, AppModule::class, ExampleRepositoryModule::class, ViewModelModule::class, ActivityBindingModule::class])
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(androidApplication: AndroidApplication): Builder

        fun build(): ApplicationComponent
    }
}