package com.serhatsurguvec.androidcleankotlin.layers.domain.repository

import com.serhatsurguvec.androidcleankotlin.core.exception.Failure
import com.serhatsurguvec.androidcleankotlin.core.functional.Either
import com.serhatsurguvec.androidcleankotlin.layers.domain.model.Example

interface ExampleRepository {
    fun examples(): Either<Failure, List<Example>>
    fun addExamples(list: List<Example>)
    fun addExample(example: Example)
}