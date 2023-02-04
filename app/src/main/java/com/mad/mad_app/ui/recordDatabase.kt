package com.mad.mad_app.ui

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [record::class], exportSchema = false, version = 7)
abstract class recordDatabase : RoomDatabase() {
    abstract fun record_dao(): recordDao

    companion object {
        private var instance: recordDatabase? = null

        @Synchronized
        fun getDatabase(ctx: Context): recordDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(
                    ctx.applicationContext, recordDatabase::class.java,
                    "note_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

            return instance!!

        }
    }
}
