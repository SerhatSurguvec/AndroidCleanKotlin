package com.serhatsurguvec.androidcleankotlin.core.di

import android.arch.persistence.room.Room
import android.content.Context
import com.serhatsurguvec.androidcleankotlin.layers.data.db.ExampleDatabase
import com.serhatsurguvec.androidcleankotlin.layers.data.repository.ExampleRepository
import dagger.Module
import dagger.Provides


/*@Module
class AppModule {

    @Singleton
    @Provides
    fun providesExampleRepository(
            networkRepository: ExampleRepository.Network,
            databaseRepository: ExampleRepository.Database): ExampleRepository = ExampleRepository.ExampleRepositoryImpl(networkRepository, databaseRepository)

    @Singleton
    @Provides
    fun providesRoomDatabase(context: Context) = Room.databaseBuilder(context, ExampleDatabase::class.java, "example-db").build()

    @Singleton
    @Provides
    fun providesExampleDao(exampleDatabase: ExampleDatabase) = exampleDatabase.exampleDao()
}*/

@Module
object AppModule {

    @JvmStatic
    @Provides
    fun providesExampleRepository(
            networkRepository: ExampleRepository.Network,
            databaseRepository: ExampleRepository.Database): ExampleRepository = ExampleRepository.ExampleRepositoryImpl(networkRepository, databaseRepository)

    @JvmStatic
    @Provides
    fun providesRoomDatabase(context: Context) = Room.databaseBuilder(context, ExampleDatabase::class.java, "example-db").build()

    @JvmStatic
    @Provides
    fun providesExampleDao(exampleDatabase: ExampleDatabase) = exampleDatabase.exampleDao()
}
