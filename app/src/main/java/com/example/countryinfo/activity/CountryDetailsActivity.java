package com.example.countryinfo.activity;

import android.content.Intent;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.caverock.androidsvg.SVG;
import com.example.countryinfo.adapter.CountryListAdapter;
import com.example.countryinfo.adapter.TextAdapter;
import com.example.countryinfo.databinding.ActivityCountryDetailsBinding;
import com.example.countryinfo.listeners.ItemClickListener;
import com.example.countryinfo.model.CountriesModel;
import com.example.countryinfo.utils.Constants;
import com.example.countryinfo.utils.Utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CountryDetailsActivity extends BaseActivity{
    private ActivityCountryDetailsBinding binding;
    private ArrayList<CountriesModel> data;
    private int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityCountryDetailsBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        data=Constants.data;
        position=Constants.postion;
        binding.tvCountryName.setText(data.get(position).getName());
        binding.tvCapital.setText(data.get(position).getCapital());
        binding.tvRegion.setText(data.get(position).getRegion());
        binding.tvSubRegion.setText(data.get(position).getSubregion());
        binding.tvPopulation.setText(data.get(position).getPopulation()+"");
        binding.rvBorders.setAdapter(new TextAdapter(data.get(position).getBorders()));
        binding.rvLanguages.setAdapter(new TextAdapter(data.get(position).getLanguages(),true));
        loadImage();

    }

    private void loadImage() {
        String flagUrl = data.get(position).getFlag();
        Utils.fetchSvg(this, flagUrl, binding.ivFlag);
    }
}
