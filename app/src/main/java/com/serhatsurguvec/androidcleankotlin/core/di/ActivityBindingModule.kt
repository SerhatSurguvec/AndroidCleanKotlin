package com.serhatsurguvec.androidcleankotlin.core.di

import com.serhatsurguvec.androidcleankotlin.features.example.ExampleActivity
import com.serhatsurguvec.androidcleankotlin.features.example.ExampleModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [ExampleModule::class])
    internal abstract fun exampleActivity(): ExampleActivity
}