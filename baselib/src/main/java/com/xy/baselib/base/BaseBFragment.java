package com.xy.baselib.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseBFragment<T extends BaseViewModel>  extends SuperFrgment {
    private Activity mainActivity;
    private View rootView;
    private Unbinder unbinder;
    public  final  String TAG=getClass().getSimpleName();

    @Inject
    protected T iModel;


    @Override
    public void onAttach(Context context) {
        if (context instanceof Activity) {
            mainActivity = getActivity();
        } else {
            throw new ClassCastException("context can't cast to activity");
        }
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getContentViewId(), container, false);
        initData();
        componentInject();
        initView();
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }




    protected abstract void initView();

    public Activity getmActivity() {
        return mainActivity;
    }




    protected abstract void initData();

    protected abstract int getContentViewId();

    protected abstract void componentInject();

    @Override
    public void onDestroy() {
        super.onDestroy();

    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder!=null){
            unbinder.unbind();
        }
        if (iModel!=null){
            iModel=null;
        }
    }


}
