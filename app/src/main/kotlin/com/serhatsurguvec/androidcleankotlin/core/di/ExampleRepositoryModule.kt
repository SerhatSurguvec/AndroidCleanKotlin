package com.serhatsurguvec.androidcleankotlin.core.di

import com.serhatsurguvec.androidcleankotlin.layers.data.repository.ExampleDataSource
import com.serhatsurguvec.androidcleankotlin.layers.data.repository.ExampleDatabaseDataSourceImpl
import com.serhatsurguvec.androidcleankotlin.layers.data.repository.ExampleNetworkDataSourceImpl
import com.serhatsurguvec.androidcleankotlin.layers.data.repository.ExampleRepositoryImpl
import com.serhatsurguvec.androidcleankotlin.layers.domain.repository.ExampleRepository
import dagger.Binds
import dagger.Module


@Module
abstract class ExampleRepositoryModule {

    @Binds
    abstract fun bindExampleRepository(exampleRepositoryImpl: ExampleRepositoryImpl): ExampleRepository

    @Binds
    abstract fun bindExampleExampleDataSourceNetwork(exampleNetworkDataSourceImpl: ExampleNetworkDataSourceImpl): ExampleDataSource.Network

    @Binds
    abstract fun bindExampleExampleDataSourceDatabase(exampleNetworkDataSourceImpl: ExampleDatabaseDataSourceImpl): ExampleDataSource.Database
}