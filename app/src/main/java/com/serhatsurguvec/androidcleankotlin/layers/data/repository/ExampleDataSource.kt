package com.serhatsurguvec.androidcleankotlin.layers.data.repository

import com.serhatsurguvec.androidcleankotlin.core.exception.Failure
import com.serhatsurguvec.androidcleankotlin.core.functional.Either
import com.serhatsurguvec.androidcleankotlin.layers.domain.model.Example

interface ExampleDataSource {
    fun examples(): Either<Failure, List<Example>>
    fun addExamples(list: List<Example>)
    fun addExample(example: Example)

    interface Network : ExampleDataSource
    interface Database : ExampleDataSource
}
