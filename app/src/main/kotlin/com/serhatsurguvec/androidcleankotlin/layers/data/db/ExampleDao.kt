package com.serhatsurguvec.androidcleankotlin.layers.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface ExampleDao {

    @Query("SELECT * FROM ExampleEntity")
    fun getExamples(): List<ExampleRoomEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExample(exampleRoomEntity: ExampleRoomEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExamples(exampleRoomEntities: List<ExampleRoomEntity>)

}