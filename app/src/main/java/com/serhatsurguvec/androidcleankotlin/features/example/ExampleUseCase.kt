package com.serhatsurguvec.androidcleankotlin.features.example

import com.serhatsurguvec.androidcleankotlin.core.usecase.UseCase
import javax.inject.Inject

class ExampleUseCase @Inject constructor(private val exampleRepository: ExampleRepository) : UseCase<List<Example>, UseCase.None>() {

    override suspend fun run(params: None) = exampleRepository.examples()
}