package com.serhatsurguvec.androidcleankotlin.layers.domain.model

import com.serhatsurguvec.androidcleankotlin.layers.data.db.ExampleRoomEntity

data class Example(
        val string: String
) {
    fun toEntity() = ExampleRoomEntity(0L, string)

}