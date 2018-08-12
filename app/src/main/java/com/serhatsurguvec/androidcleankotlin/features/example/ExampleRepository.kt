package com.serhatsurguvec.androidcleankotlin.features.example

import com.serhatsurguvec.androidcleankotlin.core.exception.Failure
import com.serhatsurguvec.androidcleankotlin.core.functional.Either
import com.serhatsurguvec.androidcleankotlin.core.platform.NetworkHandler
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
interface ExampleRepository {

    fun examples(): Either<Failure, List<Example>>

    @Singleton
    class Network @Inject constructor(private val networkHandler: NetworkHandler,
                                      private val service: ExampleApi) : ExampleRepository {

        override fun examples(): Either<Failure, List<Example>> {
            return when (networkHandler.isConnected) {
                true -> request(service.getExamples(), { it -> it.map { it.toExample() } }, emptyList())
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
    }
}