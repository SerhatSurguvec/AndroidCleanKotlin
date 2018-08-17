package com.serhatsurguvec.androidcleankotlin.layers.presentation.example

import com.serhatsurguvec.androidcleankotlin.core.di.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ExampleModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeMainFragmentInjector(): ExampleFragment
}