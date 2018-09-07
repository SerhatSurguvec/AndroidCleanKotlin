package com.serhatsurguvec.androidcleankotlin.layers.presentation.example

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.serhatsurguvec.androidcleankotlin.R
import com.serhatsurguvec.androidcleankotlin.core.extension.inflate
import com.serhatsurguvec.androidcleankotlin.layers.domain.model.Example
import kotlinx.android.synthetic.main.row_example.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class ExampleAdapter
@Inject constructor() : RecyclerView.Adapter<ExampleAdapter.ViewHolder>() {

    internal var collection: List<Example> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    internal var clickListener: (Example, View) -> Unit = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(parent.inflate(R.layout.row_example))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
            viewHolder.bind(collection[position], clickListener)

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movieView: Example, clickListener: (Example, View) -> Unit) {
            itemView.exampleText.text = movieView.string
            itemView.setOnClickListener { clickListener(movieView, itemView.exampleText) }
        }
    }
}