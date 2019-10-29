package com.xy.baselib.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SuperFrgment extends Fragment {
    private Context mContext;
    private ViewGroup childAt;
    private View errorView;
    private View networkView;

    @Override
    public void onAttach(Context context) {
        if (context instanceof Activity) {
            mContext = getActivity();
        } else {
            throw new ClassCastException("context can't cast to activity");
        }
        super.onAttach(context);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        childAt = ((Activity)mContext).findViewById(android.R.id.content);
//        errorView = LayoutInflater.from(mContext).inflate(null, null);
//        networkView = LayoutInflater.from(mContext).inflate(null, null);
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
