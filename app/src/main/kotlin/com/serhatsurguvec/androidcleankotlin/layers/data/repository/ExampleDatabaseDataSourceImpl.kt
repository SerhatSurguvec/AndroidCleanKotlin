package com.serhatsurguvec.androidcleankotlin.layers.data.repository

import com.serhatsurguvec.androidcleankotlin.core.exception.Failure
import com.serhatsurguvec.androidcleankotlin.core.functional.Either
import com.serhatsurguvec.androidcleankotlin.layers.data.db.ExampleDao
import com.serhatsurguvec.androidcleankotlin.layers.domain.model.Example
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExampleDatabaseDataSourceImpl @Inject constructor(private val exampleDao: ExampleDao) : ExampleDataSource.Database {
    override fun examples(): Either<Failure, List<Example>> {
        val list = exampleDao.getExamples()
                .map { it -> it.toExample() }
        return Either.Right(list)
    }

    override fun addExamples(list: List<Example>) {
        exampleDao.insertExamples(list.map { it.toEntity() })
    }

    override fun addExample(example: Example) {
        exampleDao.insertExample(example.toEntity())
    }
}