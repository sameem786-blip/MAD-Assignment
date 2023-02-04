package com.mad.mad_app.ui

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class record(
    @PrimaryKey(autoGenerate = true) var id : Int? = null,
    @ColumnInfo(name = "name") var name : String,
    @ColumnInfo(name = "description") var description : String,
    @ColumnInfo(name = "isFav") var isFav : Boolean
)
