package com.jaegerpicker.covid19api.ui.areas

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jaegerpicker.covid19api.data.remote.domain.Areas

@BindingAdapter(value = ["areas", "viewModel"])
fun setAreas(view: RecyclerView, items: List<Areas>, vm: AreasViewModel) {
    view.adapter?.run {
        if (this is AreasAdapter) {
            this.items = items
            this.notifyDataSetChanged()
        }
    } ?: run {
        AreasAdapter(items, vm).apply { view.adapter = this}
    }
}