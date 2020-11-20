package com.example.countryinfo.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.Keep;
import androidx.room.Room;

import com.example.countryinfo.model.CountriesModel;

import java.util.ArrayList;
import java.util.List;

@Keep
public class DatabaseOperation {

    private String DB_NAME="location_db";
    private List<CountryTable> countryTables =new ArrayList<>();
    private AppDatabase appDatabase;
    private FetchData fetchData;

    public DatabaseOperation(Context context){
        appDatabase = Room.databaseBuilder(context, AppDatabase.class,DB_NAME).build();
    }
    public void insertTask(CountryTable data){
        new AsyncTask<Void, Void, Long>(){

            @Override
            protected Long doInBackground(Void... voids) {
                return appDatabase.daoAccess().insertTask(data);
            }
        }.execute();

    }
    public void deleteTask(String key)
    {
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.daoAccess().deletAll();
                return null;
            }
        }.execute();
    }
    public void getTasks(FetchData fetchData){
        this.fetchData =fetchData;
        new AsyncTask<Void, Void, List<CountryTable>>(){


            @Override
            protected List<CountryTable> doInBackground(Void... voids) {
                countryTables = appDatabase.daoAccess().retrieveAllTask();
                return countryTables;
            }

            @Override
            protected void onPostExecute(List<CountryTable> savedData) {
                super.onPostExecute(savedData);
                if (!savedData.isEmpty())
                    fetchData.savedData(savedData);
                else {
                    fetchData.setError("Internet Required For First Time");
                }
            }
        }.execute();

    }
    public interface FetchData {

        void savedData(List<CountryTable> savedData);

        void setError(String message);
    }

}
