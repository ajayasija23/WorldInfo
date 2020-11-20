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

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.MyViewHolder> {

    private ArrayList<CountriesModel> data;
    private ItemClickListener listener;
    Context mContext;
    private ArrayList<Integer> colors=new ArrayList();
    public CountryListAdapter(ArrayList<CountriesModel> data, ItemClickListener listener) {
        this.data=data;
        this.listener=listener;
        colors.add(R.color.orange);
        colors.add(R.color.purple_200);
        colors.add(R.color.teal_200);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext=parent.getContext();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_country_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       holder.tvCountryName.setText(data.get(position).getName());
       holder.rlHolder.setBackgroundColor(mContext.getResources().getColor(colors.get(position%colors.size())));
       holder.rlHolder.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            listener.onItemClick(position,data);
           }
       });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvCountryName;
        RelativeLayout rlHolder;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountryName=itemView.findViewById(R.id.tvCountryName);
            rlHolder=itemView.findViewById(R.id.rlHolder);
        }
    }
}
