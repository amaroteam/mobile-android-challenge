package com.test.amaro.amarotest.presentation.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.test.amaro.amarotest.AmaroApplication;
import com.test.amaro.amarotest.dagger.components.ActivityComponent;

public class BaseActivity extends AppCompatActivity implements MvpView {

    private ActivityComponent activityComponent;

    protected final ActivityComponent getActivityComponent() {
        return this.activityComponent;
    }

    @Override
    @SuppressWarnings("UsePropertyAccessSyntax")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public BaseActivity() {
        this.activityComponent = AmaroApplication.getApplicationComponent().activityComponent();
    }


}
