package com.jaegerpicker.covid19api.ui.information

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.jaegerpicker.covid19api.R
import com.jaegerpicker.covid19api.ui.BindingViewHolder
import com.jaegerpicker.covid19api.data.db.entity.Information
import com.jaegerpicker.covid19api.databinding.ItemInformationBinding

class InformationAdapter(val vm: InformationViewModel) :
    PagedListAdapter<Information, InformationAdapter.BookmarkViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        return BookmarkViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_information,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        getItem(position)?.run {
            holder.binding.item = this
            holder.binding.vm = vm
        }
    }

    class BookmarkViewHolder(view: View) : BindingViewHolder<ItemInformationBinding>(view)

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Information>() {
            override fun areItemsTheSame(oldItem: Information, newItem: Information) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Information, newItem: Information) = oldItem == newItem
        }
    }
}