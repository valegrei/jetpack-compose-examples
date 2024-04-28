package com.aiviktor.roomcronoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aiviktor.roomcronoapp.model.Cronos


@Database(entities = [Cronos::class], version = 1, exportSchema = false)
abstract class CronosDatabase: RoomDatabase() {
    abstract fun cronosDao(): CronosDatabaseDao

}