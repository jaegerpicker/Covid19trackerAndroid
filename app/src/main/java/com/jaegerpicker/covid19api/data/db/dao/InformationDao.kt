package com.jaegerpicker.covid19api.data.db.dao

import androidx.paging.DataSource
import androidx.room.*
import com.jaegerpicker.covid19api.data.db.entity.Information

@Dao
interface InformationDao {
    @Query("SELECT * FROM Information ORDER BY priKey")
    fun findAll(): DataSource.Factory<Int, Information>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(information: Information)

    @Delete
    fun delete(information: Information)
}