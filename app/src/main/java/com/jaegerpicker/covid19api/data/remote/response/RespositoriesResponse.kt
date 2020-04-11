package com.jaegerpicker.covid19api.data.remote.response

import com.google.gson.annotations.SerializedName
import com.jaegerpicker.covid19api.data.remote.domain.Areas
import java.util.*
import kotlin.collections.ArrayList

data class RespositoriesResponse(
    @SerializedName("id") val id: String,
    @SerializedName("displayName") val displayName: String,
    @SerializedName("areas") val areas: ArrayList<Areas>,
    @SerializedName("totalConfirmed") val totalConfirmed: Int,
    @SerializedName("totalDeaths") val totalDeaths: Int,
    @SerializedName("totalRecovered") val totalRecovered: Int,
    @SerializedName("totalRecoveredDelta") val totalRecoveredDelta: Int,
    @SerializedName("totalDeathsDelta") val totalDeathsDelta: Int,
    @SerializedName("totalConfirmedDelta") val totalConfirmedDelta: Int,
    @SerializedName("lastUpdated") val lastUpdated: Date
)