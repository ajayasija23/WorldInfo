package com.example.countryinfo.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.countryinfo.model.CountriesModel;

import java.util.List;

@Dao
public interface DaoAccess {

    @Insert
    Long insertTask (CountryTable table);

    @Query("SELECT * FROM CountryTable")
    List<CountryTable> retrieveAllTask();

    @Query("DELETE FROM CountryTable WHERE 1")
    public void deletAll();

}
