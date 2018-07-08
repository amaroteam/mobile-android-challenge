package com.test.amaro.amarotest;

import android.app.Application;
import com.test.amaro.amarotest.dagger.components.ApplicationComponent;
import com.test.amaro.amarotest.dagger.components.DaggerApplicationComponent;
import com.test.amaro.amarotest.dagger.modules.ApplicationModule;

public final class AmaroApplication extends Application {

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initDagger();
    }

    private void initDagger() {
        ApplicationComponent auxApplicationComponent =
                DaggerApplicationComponent
                        .builder()
                        .applicationModule(new ApplicationModule(this))
                        .build();
        setApplicationComponent(auxApplicationComponent);
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static void setApplicationComponent(ApplicationComponent applicationComponent) {
        AmaroApplication.applicationComponent = applicationComponent;
    }

}
