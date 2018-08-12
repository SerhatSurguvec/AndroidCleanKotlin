package com.serhatsurguvec.androidcleankotlin.core.platform

import android.os.Bundle
import android.support.v4.app.Fragment
import com.serhatsurguvec.androidcleankotlin.R.id
import com.serhatsurguvec.androidcleankotlin.R.layout
import com.serhatsurguvec.androidcleankotlin.core.extension.inTransaction
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Base Activity class with helper methods for handling fragment transactions and back button
 * events.
 *
 * @see AppCompatActivity
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_layout)
        setSupportActionBar(toolbar)
        addFragment(savedInstanceState)
    }

    override fun onBackPressed() {
        (fragmentManager.findFragmentById(
                id.fragmentContainer) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }

    private fun addFragment(savedInstanceState: Bundle?) =
            savedInstanceState ?: supportFragmentManager.inTransaction {
                add(
                        id.fragmentContainer, fragment())
            }

    abstract fun fragment(): Fragment
}