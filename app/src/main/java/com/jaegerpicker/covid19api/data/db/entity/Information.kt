package com.jaegerpicker.covid19api.data.db.entity

import androidx.room.*
import com.jaegerpicker.covid19api.data.db.convertor.DateConverter
import com.jaegerpicker.covid19api.data.remote.domain.Areas
import java.util.*

@Entity(tableName = "Information")
@TypeConverters(DateConverter::class)
data class Information(
    @PrimaryKey(autoGenerate = true) val priKey: Int = 0,
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "displayName") val displayName: String,
    @ColumnInfo(name = "areaIds") val areas: ArrayList<Areas>,
    @ColumnInfo(name = "totalConfirmed") val totalConfirmed: Int,
    @ColumnInfo(name = "totalDeaths") val totalDeaths: Int,
    @ColumnInfo(name = "totalRecovered") val totalRecovered: Int,
    @ColumnInfo(name = "totalRecoveredDelta") val totalRecoveredDelta: Int,
    @ColumnInfo(name = "totalDeathsDelta") val totalDeathsDelta: Int,
    @ColumnInfo(name = "totalConfirmedDelta") val totalConfirmedDelta: Int,
    @ColumnInfo(name = "lastUpdated") val lastUpdated: Date,
    @ColumnInfo(name = "lat") val lat: Float,
    @ColumnInfo(name = "lon") val lon: Float,
    @ColumnInfo(name = "parentId") val parentId: String
) {
    companion object {
        fun to(area: Areas): Information {
            return Information(
                id = area.id,
                displayName = area.displayName,
                areas = area.areas,
                totalConfirmed = area.totalConfirmed,
                totalDeaths = area.totalDeaths,
                totalRecovered = area.totalRecovered,
                totalRecoveredDelta = area.totalRecoveredDelta,
                totalDeathsDelta = area.totalDeathsDelta,
                totalConfirmedDelta = area.totalConfirmedDelta,
                lastUpdated = area.lastUpdated,
                lat = area.lat,
                lon = area.lon,
                parentId = area.parentId
            )
        }
    }
}