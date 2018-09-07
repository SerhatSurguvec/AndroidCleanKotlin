package com.serhatsurguvec.androidcleankotlin.layers.data.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.serhatsurguvec.androidcleankotlin.layers.domain.model.Example

@Entity(tableName = "ExampleEntity")
data class ExampleRoomEntity(
        @PrimaryKey(autoGenerate = true) val id: Long,
        @ColumnInfo(name = "example") val example: String
) {
    fun toExample() = Example(example)
}