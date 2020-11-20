package com.example.countryinfo.listeners;

import com.example.countryinfo.model.CountriesModel;

import java.util.ArrayList;
import java.util.List;

public interface ItemClickListener {
    void onItemClick(int postion, ArrayList<CountriesModel> data);
}
