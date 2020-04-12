package com.jaegerpicker.covid19api.ui.information

import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.jaegerpicker.covid19api.data.db.entity.Information


@BindingAdapter(value = ["information", "viewModel"])
fun setInformation(view: RecyclerView, items: PagedList<Information>?, vm: InformationViewModel) {
    view.adapter?.run {
        if (this is InformationAdapter) this.submitList(items)
    } ?: run {
        InformationAdapter(vm).apply {
            view.adapter = this
            this.submitList(items)
        }
    }
}