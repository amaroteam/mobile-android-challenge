package com.amaro.bruno.amarochallenge.catalogue.products.di;

import com.amaro.bruno.amarochallenge.MainApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        BuildersModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(MainApplication application);
        AppComponent build();
    }
    void inject(MainApplication application);

}
