package com.serhatsurguvec.androidcleankotlin.layers.presentation.example

import android.arch.lifecycle.MutableLiveData
import com.serhatsurguvec.androidcleankotlin.core.platform.BaseViewModel
import com.serhatsurguvec.androidcleankotlin.core.usecase.UseCase
import com.serhatsurguvec.androidcleankotlin.layers.domain.model.Example
import com.serhatsurguvec.androidcleankotlin.layers.domain.interactor.ExampleUseCase
import javax.inject.Inject

class ExampleViewModel @Inject constructor(private val exampleUseCase: ExampleUseCase) : BaseViewModel() {

    var examples: MutableLiveData<List<Example>> = MutableLiveData()

    fun loadExamples() = exampleUseCase(UseCase.None()) { it.either(::handleFailure, ::handleExampleList) }

    private fun handleExampleList(examples: List<Example>) {
        this.examples.value = examples
    }
}
