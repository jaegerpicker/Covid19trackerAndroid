package com.jaegerpicker.covid19api.ui.areas

import com.jaegerpicker.covid19api.core.BaseViewModel
import com.jaegerpicker.covid19api.data.db.dao.InformationDao
import com.jaegerpicker.covid19api.data.db.entity.Information
import com.jaegerpicker.covid19api.data.remote.api.CovidInfo
import com.jaegerpicker.covid19api.data.remote.domain.Areas
import com.jaegerpicker.covid19api.util.NotNullMutableLiveData
import com.jaegerpicker.covid19api.util.ioThread
import com.jaegerpicker.covid19api.extension.with

class AreasViewModel(private val api: CovidInfo, private val dao: InformationDao) : BaseViewModel() {
    private var query: String = ""
        get() = if (field.isEmpty()) "Covid19" else field

    private val _refreshing: NotNullMutableLiveData<Boolean> = NotNullMutableLiveData(false)
    val refreshing: NotNullMutableLiveData<Boolean>
        get() = _refreshing

    private val _items: NotNullMutableLiveData<List<Areas>> = NotNullMutableLiveData(arrayListOf())
    val items: NotNullMutableLiveData<List<Areas>>
        get() = _items

    fun doSearch() {
        val params = mutableMapOf<String, String>().apply {
            this["q"] = query
            this["sort"] = "lastUpdated"
        }

        addToDisposable(api.info(params).with()
            .doOnSubscribe { _refreshing.value = true }
            .doOnSuccess { _refreshing.value = false }
            .doOnError { _refreshing.value = false }
            .subscribe({
                _items.value = it.areas
            }, {
                // handle errors
            }))
    }

    fun onQueryChange(query: CharSequence) {
        this.query = query.toString()
    }

    fun saveToInformation(repository: Areas) = ioThread { dao.insert(Information.to(repository)) }
}