package com.serhatsurguvec.androidcleankotlin.layers.data.repository

import com.serhatsurguvec.androidcleankotlin.core.exception.Failure
import com.serhatsurguvec.androidcleankotlin.core.functional.Either
import com.serhatsurguvec.androidcleankotlin.layers.domain.model.Example
import com.serhatsurguvec.androidcleankotlin.layers.domain.repository.ExampleRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExampleRepositoryImpl @Inject constructor(
        private val networkRepository: ExampleDataSource.Network,
        private val databaseRepository: ExampleDataSource.Database) : ExampleRepository {

    //TODO("not implemented")
    var isDirty = true

    override fun examples(): Either<Failure, List<Example>> {
        //BI
        val examplesFromNetwork = networkRepository.examples()

        return if (examplesFromNetwork.isRight) {
            examplesFromNetwork.either(::print, databaseRepository::addExamples)
            examplesFromNetwork
        } else {
            val examplesFromDB = databaseRepository.examples()
            return if (examplesFromDB.isLeft) {
                Either.Left(Failure.ServerError())
            } else {
                examplesFromDB
            }
        }
    }

    override fun addExamples(list: List<Example>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addExample(example: Example) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


