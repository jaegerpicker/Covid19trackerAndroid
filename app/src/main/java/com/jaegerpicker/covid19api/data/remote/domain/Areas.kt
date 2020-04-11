package com.jaegerpicker.covid19api.data.remote.domain

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

data class Areas(
    @SerializedName("id") val id: String,
    @SerializedName("displayName") val displayName: String,
    @SerializedName("areas") val areas: ArrayList<Areas>,
    @SerializedName("totalConfirmed") val totalConfirmed: Int,
    @SerializedName("totalDeaths") val totalDeaths: Int,
    @SerializedName("totalRecovered") val totalRecovered: Int,
    @SerializedName("totalRecoveredDelta") val totalRecoveredDelta: Int,
    @SerializedName("totalDeathsDelta") val totalDeathsDelta: Int,
    @SerializedName("totalConfirmedDelta") val totalConfirmedDelta: Int,
    @SerializedName("lastUpdated") val lastUpdated: Date,
    @SerializedName("lat") val lat: Float,
    @SerializedName("lon") val lon: Float,
    @SerializedName("parentId") val parentId: String
)