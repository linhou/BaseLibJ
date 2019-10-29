package com.xy.baselib.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.xy.baselib.utils.AndroidWorkaround;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseDActivity<T extends BaseViewModel,D extends ViewDataBinding> extends SuperActivity {

    public final String TAG = getClass().getSimpleName();
    public Unbinder bind;

    protected  D mBinding;


    private List<AppCompatActivity> mloginActivitys;

    @Inject
    protected T iModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        mBinding= DataBindingUtil.setContentView(this,getContentViewId());
        mloginActivitys=new ArrayList<>();
        if (AndroidWorkaround.checkDeviceHasNavigationBar(this)) {
            AndroidWorkaround.assistActivity(findViewById(android.R.id.content));
            //todo 底部导航栏
            // 在setContentView之后，适配顶部状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //  适配底部导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        }
        componentInject();
        initData();
        initView(mBinding);
//        setListener();

    }


    protected abstract int getContentViewId();
    protected abstract void initData();
    protected abstract void componentInject();
    protected abstract void initView(D binding);
    protected abstract void setListener();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != Unbinder.EMPTY) {
            bind.unbind();
        }
        if (iModel!=null){
            iModel=null;
        }
    }


    public T getiModel() {
        return iModel;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (AndroidWorkaround.checkDeviceHasNavigationBar(this)) {
            AndroidWorkaround.assistActivity(findViewById(android.R.id.content));
        }
    }

    protected void addLogin(AppCompatActivity activity){
        mloginActivitys.add(activity);
    }

    protected  void removeLogin() {
        for (AppCompatActivity activity : mloginActivitys) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }


}
