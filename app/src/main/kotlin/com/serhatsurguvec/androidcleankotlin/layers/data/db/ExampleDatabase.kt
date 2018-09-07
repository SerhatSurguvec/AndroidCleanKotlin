package com.serhatsurguvec.androidcleankotlin.layers.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [ExampleRoomEntity::class], version = 1)
abstract class ExampleDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao
}