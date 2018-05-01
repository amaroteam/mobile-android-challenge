package com.amaro.bruno.amarochallenge.catalogue.products.di;

import android.content.Context;

import com.amaro.bruno.amarochallenge.MainApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    Context providesContext(MainApplication application){
        return application.getApplicationContext();
    }

}
