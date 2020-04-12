package com.jaegerpicker.covid19api.ui.information

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.jaegerpicker.covid19api.core.BaseViewModel
import com.jaegerpicker.covid19api.data.db.dao.InformationDao
import com.jaegerpicker.covid19api.data.db.entity.Information
import com.jaegerpicker.covid19api.util.ioThread


class InformationViewModel(private val dao: InformationDao) : BaseViewModel() {
    val items: LiveData<PagedList<Information>> = LivePagedListBuilder(dao.findAll(), 10).build()

    fun delete(information: Information) = ioThread { dao.delete(information) }
}