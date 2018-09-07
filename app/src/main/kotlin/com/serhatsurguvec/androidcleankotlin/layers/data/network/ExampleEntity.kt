package com.serhatsurguvec.androidcleankotlin.layers.data.network

import com.serhatsurguvec.androidcleankotlin.layers.domain.model.Example

data class ExampleEntity(
        val string: String
) {
    fun toExample() = Example(string)
}