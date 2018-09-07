package com.serhatsurguvec.androidcleankotlin.layers.data.repository

import com.serhatsurguvec.androidcleankotlin.core.exception.Failure
import com.serhatsurguvec.androidcleankotlin.core.functional.Either
import com.serhatsurguvec.androidcleankotlin.core.platform.NetworkHandler
import com.serhatsurguvec.androidcleankotlin.layers.data.network.ExampleService
import com.serhatsurguvec.androidcleankotlin.layers.domain.model.Example
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExampleNetworkDataSourceImpl @Inject constructor(private val networkHandler: NetworkHandler,
                                                       private val service: ExampleService) : ExampleDataSource.Network {
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