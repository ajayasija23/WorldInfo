package com.example.countryinfo.utils;


import androidx.room.TypeConverter;

import com.example.countryinfo.model.CountriesModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TypesConverter {

    public  static Gson gson = new Gson();

    @TypeConverter
    public String fromCountryLangList(ArrayList<CountriesModel> countryLang) {
        if (countryLang == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<CountriesModel>>() {}.getType();
        String json = gson.toJson(countryLang, type);
        return json;
    }

    @TypeConverter
    public ArrayList<CountriesModel> toCountryLangList(String countryLangString) {
        if (countryLangString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<CountriesModel>>() {}.getType();
        ArrayList<CountriesModel> countryLangList = gson.fromJson(countryLangString, type);
        return countryLangList;
    }
}