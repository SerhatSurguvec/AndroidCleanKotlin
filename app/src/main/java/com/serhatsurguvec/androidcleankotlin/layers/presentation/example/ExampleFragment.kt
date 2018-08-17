package com.serhatsurguvec.androidcleankotlin.layers.presentation.example

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.serhatsurguvec.androidcleankotlin.R
import com.serhatsurguvec.androidcleankotlin.core.exception.Failure
import com.serhatsurguvec.androidcleankotlin.core.extension.*
import com.serhatsurguvec.androidcleankotlin.core.platform.BaseFragment
import com.serhatsurguvec.androidcleankotlin.layers.domain.model.Example
import kotlinx.android.synthetic.main.fragment_example.*
import timber.log.Timber
import javax.inject.Inject

class ExampleFragment : BaseFragment() {

    @Inject
    lateinit var exampleAdapter: ExampleAdapter

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
        initializeView()
        loadExampleList()
    }

    private fun loadExampleList() {
        emptyView.invisible()
        exampleList.visible()
        showProgress()
        exampleViewModel.loadExamples()
    }

    private fun initializeView() {
        exampleList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = exampleAdapter
            addItemDecoration(DividerItemDecoration(context, (layoutManager as LinearLayoutManager).orientation))
        }

        exampleAdapter.clickListener = { example, _ ->
            Toast.makeText(context, "Clicked on ${example.string}", Toast.LENGTH_SHORT)
                    .show()
        }
    }

    private fun handleFailure(failure: Failure?) {
        Timber.d(failure.toString())
    }

    private fun renderMoviesList(examples: List<Example>?) {
        exampleAdapter.collection = examples.orEmpty()
        hideProgress()
    }
}