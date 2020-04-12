package com.jaegerpicker.covid19api.ui.areas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jaegerpicker.covid19api.R
import com.jaegerpicker.covid19api.data.remote.domain.Areas
import com.jaegerpicker.covid19api.databinding.ItemRepositoryBinding
import com.jaegerpicker.covid19api.ui.BindingViewHolder

class AreasAdapter(var items: List<Areas> = arrayListOf(), val vm: SearchViewModel) :
    RecyclerView.Adapter<AreasAdapter.AreasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreasViewHolder {
        return AreasViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_areas,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AreasViewHolder, position: Int) {
        holder.binding.item = items[position]
        holder.binding.vm = vm
    }

    override fun getItemCount() = items.size
    class AreasViewHolder(view: View) : BindingViewHolder<AreaBinding>(view)
}