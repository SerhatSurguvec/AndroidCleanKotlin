package com.serhatsurguvec.androidcleankotlin.core.di

import android.content.Context
import com.serhatsurguvec.androidcleankotlin.AndroidApplication
import dagger.Binds
import dagger.Module


@Module
abstract class ApplicationModule {
    //expose Application as an injectable context
    @Binds
    abstract fun bindContext(androidApplication: AndroidApplication): Context

}