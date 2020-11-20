package com.example.countryinfo.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.example.countryinfo.R;


public class BaseActivity extends AppCompatActivity {

    private Dialog mDialog;

    public void showProgressDialog(){
        mDialog=new Dialog(this);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.layout_progress_bar);
        mDialog.setCancelable(true);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();

    }
    public void hideProgressDialog(){
        mDialog.dismiss();
    }
}
