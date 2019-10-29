package com.xy.baselib.base;

import com.xy.baselib.mvvm.IModel;
import com.xy.baselib.mvvm.IView;

public class BaseViewModel<T extends IView,B extends IModel> implements android.arch.lifecycle.LifecycleObserver {
    private  T view;
    private  B model;



    public BaseViewModel(T mV,B mM){
        this.view=mV;
        this.model=mM;

    }

    public T getView() {
        return view;
    }


    public void setView(T view) {
        this.view = view;
    }

    public B getModel() {
        return model;
    }

    public void setModel(B model) {
        this.model = model;
    }


}
