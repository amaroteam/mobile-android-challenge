package com.amaro.bruno.amarochallenge;

import android.support.v7.app.AppCompatActivity;

import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnbinder;

    public void setUnbinder(Unbinder unbinder){
        mUnbinder = unbinder;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if(mUnbinder != null){
            mUnbinder.unbind();
        }
    }

    protected abstract void setup();

}
