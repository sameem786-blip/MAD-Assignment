package com.mad.mad_app.ui

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface recordDao {
    @Query("SELECT * FROM users")
    suspend fun getAllRecords() : List<record>

    @Query("SELECT * FROM users WHERE isFav LIKE 1")
    suspend fun getFavorites() : List<record>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(recordInput : record)

    @Update
    suspend fun update(recordInput: record)
}