package com.serhatsurguvec.androidcleankotlin.layers.presentation.example

import android.os.Bundle
import android.view.View
import com.serhatsurguvec.androidcleankotlin.R
import com.serhatsurguvec.androidcleankotlin.core.exception.Failure
import com.serhatsurguvec.androidcleankotlin.core.extension.failure
import com.serhatsurguvec.androidcleankotlin.core.extension.observe
import com.serhatsurguvec.androidcleankotlin.core.extension.viewModel
import com.serhatsurguvec.androidcleankotlin.core.platform.BaseFragment
import com.serhatsurguvec.androidcleankotlin.layers.domain.model.Example
import timber.log.Timber

class ExampleFragment : BaseFragment() {

    private lateinit var exampleViewModel: ExampleViewModel

    override fun layoutId(): Int {
        return R.layout.fragment_example
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        exampleViewModel = viewModel(viewModelFactory) {
            observe(examples, ::renderMoviesList)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exampleViewModel.loadExamples()
    }

    private fun handleFailure(failure: Failure?) {
        Timber.d(failure.toString())
    }

    private fun renderMoviesList(list: List<Example>?) {
        Timber.d("Works")
    }
}