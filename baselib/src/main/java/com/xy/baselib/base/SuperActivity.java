package com.xy.baselib.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xy.baselib.R;

public class SuperActivity extends AppCompatActivity {

    protected ViewGroup childAt;

    protected View errorView;
    protected View networkView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        childAt =  findViewById(android.R.id.content);
        errorView = LayoutInflater.from(this).inflate(null, null);
        networkView = LayoutInflater.from(this).inflate(null, null);

    }

    public void showErrorView(){
        childAt.addView(errorView);
    }

    public void showNetworkView(){
        childAt.addView(networkView);
    }

    public void dissNetworkView(){
        childAt.removeView(networkView);
    }

    public void dissErrorView(){childAt.removeView(errorView);}


}
