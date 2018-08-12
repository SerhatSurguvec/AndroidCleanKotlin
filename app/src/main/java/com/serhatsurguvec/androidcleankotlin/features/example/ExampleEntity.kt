package com.serhatsurguvec.androidcleankotlin.features.example

data class ExampleEntity(
        val string: String
) {

    fun toExample() = Example(string)
}