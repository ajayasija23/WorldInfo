package com.example.countryinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countryinfo.R;
import com.example.countryinfo.listeners.ItemClickListener;
import com.example.countryinfo.model.CountriesModel;

import java.util.ArrayList;
import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.MyViewHolder> {

    List<String> data;
    List<CountriesModel.LanguagesBean> languages;
    boolean isLanguages=false;
    public TextAdapter(List<String> data) {
        this.data=data;
    }

    public TextAdapter(List<CountriesModel.LanguagesBean> languages,boolean isLanguages) {
        this.isLanguages=isLanguages;
        this.languages=languages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_textviews,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (isLanguages){
            holder.tvText.setText(languages.get(position).getNativeName());
        }
         else {
            holder.tvText.setText(data.get(position));
         }
    }

    @Override
    public int getItemCount() {
        if (isLanguages){
            return languages.size();
        }
        return data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvText=itemView.findViewById(R.id.tvText);

        }
    }
}
