package com.serhatsurguvec.androidcleankotlin.layers.domain.interactor

import com.serhatsurguvec.androidcleankotlin.core.usecase.UseCase
import com.serhatsurguvec.androidcleankotlin.layers.domain.model.Example
import com.serhatsurguvec.androidcleankotlin.layers.domain.repository.ExampleRepository
import javax.inject.Inject

class ExampleUseCase @Inject constructor(private val exampleRepository: ExampleRepository) : UseCase<List<Example>, UseCase.None>() {

    override suspend fun run(params: None) = exampleRepository.examples()
}