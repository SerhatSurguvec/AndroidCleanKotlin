package com.serhatsurguvec.androidcleankotlin.layers.presentation.example

import com.serhatsurguvec.androidcleankotlin.core.platform.BaseActivity
import com.serhatsurguvec.androidcleankotlin.core.platform.BaseFragment

class ExampleActivity : BaseActivity() {

    override fun fragment(): BaseFragment {
        return ExampleFragment()
    }
}