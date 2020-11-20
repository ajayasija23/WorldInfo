package com.example.countryinfo.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.countryinfo.adapter.CountryListAdapter;
import com.example.countryinfo.database.CountryTable;
import com.example.countryinfo.database.DatabaseOperation;
import com.example.countryinfo.databinding.ActivityMainBinding;
import com.example.countryinfo.listeners.ItemClickListener;
import com.example.countryinfo.model.CountriesModel;
import com.example.countryinfo.utils.Constants;
import com.example.countryinfo.web.WebApi;
import com.example.countryinfo.web.Webservices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements ItemClickListener, DatabaseOperation.FetchData {

    private ActivityMainBinding binding;
    private WebApi api;
    private DatabaseOperation dbOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        dbOperation=new DatabaseOperation(this);
        if (isNetworkAvailable()){
            showProgressDialog();
            api= Webservices.getInstance().getWebApi();
            setCallback();
        }
        else {
            dbOperation.getTasks(this);
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void setCallback() {
        Call<ArrayList<CountriesModel>> call=api.getCountries();
        call.enqueue(new Callback<ArrayList<CountriesModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CountriesModel>> call, Response<ArrayList<CountriesModel>> response) {
                hideProgressDialog();
                if (response.isSuccessful()){
                    saveData(response.body());
                    setAdapter(response.body());
                }
                else {
                    Log.d("response",response.message());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CountriesModel>> call, Throwable t) {
                Log.d("response",t.getMessage());
            }
        });
    }

    private void saveData(ArrayList<CountriesModel> body) {
        CountryTable table=new CountryTable();
        table.setData(body);
        dbOperation.insertTask(table);
        dbOperation.getTasks(this);
    }


    private void setAdapter(ArrayList<CountriesModel> body) {
        binding.rvCountriesList.setAdapter(new CountryListAdapter(body,this));
        binding.rvCountriesList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvCountriesList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onItemClick(int postion, ArrayList<CountriesModel> data) {
        Constants.postion=postion;
        Constants.data=data;
        Intent intent=new Intent(MainActivity.this,CountryDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void savedData(List<CountryTable> savedData) {
        if(savedData!=null){
            setAdapter(savedData.get(0).getData());
        }
    }

    @Override
    public void setError(String message) {
        messageDialog(message);
    }

    public void messageDialog(String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                builder.create().dismiss();
                finish();
            }
        });
        builder.show();
    }
}