package com.serhatsurguvec.androidcleankotlin.layers.data.repository

import com.serhatsurguvec.androidcleankotlin.core.exception.Failure
import com.serhatsurguvec.androidcleankotlin.core.functional.Either
import com.serhatsurguvec.androidcleankotlin.core.platform.NetworkHandler
import com.serhatsurguvec.androidcleankotlin.layers.data.db.ExampleDao
import com.serhatsurguvec.androidcleankotlin.layers.domain.model.Example
import com.serhatsurguvec.androidcleankotlin.layers.data.network.ExampleService
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
interface ExampleRepository {

    fun examples(): Either<Failure, List<Example>>
    fun addExamples(list: List<Example>)
    fun addExample(example: Example)

    @Singleton
    class ExampleRepositoryImpl @Inject constructor(
            private val networkRepository: Network,
            private val databaseRepository: Database) : ExampleRepository {

        //TODO("not implemented")
        var isDirty = true

        override fun examples(): Either<Failure, List<Example>> {
            //BI
            val examplesFromNetwork = networkRepository.examples()

            return if (examplesFromNetwork.isLeft) {
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

    @Singleton
    class Network @Inject constructor(private val networkHandler: NetworkHandler,
                                      private val service: ExampleService) : ExampleRepository {

        override fun examples(): Either<Failure, List<Example>> {
            return when (networkHandler.isConnected) {
                true -> request(service.api.getExamples(), { it -> it.map { it.toExample() } }, emptyList())
                false, null -> Either.Left(Failure.NetworkConnection())
            }
        }

        private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform((response.body() ?: default)))
                    false -> Either.Left(Failure.ServerError())
                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError())
            }
        }

        override fun addExamples(list: List<Example>) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun addExample(example: Example) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    @Singleton
    class Database @Inject constructor(private val exampleDao: ExampleDao) : ExampleRepository {
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
}