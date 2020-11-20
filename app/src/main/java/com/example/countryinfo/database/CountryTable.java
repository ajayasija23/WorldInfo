package com.example.countryinfo.database;

import androidx.annotation.Keep;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.countryinfo.model.CountriesModel;
import com.example.countryinfo.utils.TypesConverter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class CountryTable implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @TypeConverters(TypesConverter.class)
    private ArrayList<CountriesModel> data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<CountriesModel> getData() {
        return data;
    }

    public void setData(ArrayList<CountriesModel> data) {
        this.data = data;
    }
}
