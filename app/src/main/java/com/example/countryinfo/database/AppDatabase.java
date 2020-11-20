package com.example.countryinfo.database;

import androidx.annotation.Keep;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Keep
@Database(entities = {CountryTable.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DaoAccess daoAccess();
}
