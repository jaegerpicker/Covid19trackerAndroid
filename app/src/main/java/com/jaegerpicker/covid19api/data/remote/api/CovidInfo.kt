package com.jaegerpicker.covid19api.data.remote.api

import com.jaegerpicker.covid19api.data.remote.response.RespositoriesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface CovidInfo {

    @GET("/")
    fun info(@QueryMap params: MutableMap<String, String>): Single<RespositoriesResponse>
}