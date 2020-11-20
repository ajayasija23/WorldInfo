package com.example.countryinfo.web;

import com.example.countryinfo.model.CountriesModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebApi {

    @GET("/rest/v2/region/asia")
    Call<ArrayList<CountriesModel>> getCountries();
}
