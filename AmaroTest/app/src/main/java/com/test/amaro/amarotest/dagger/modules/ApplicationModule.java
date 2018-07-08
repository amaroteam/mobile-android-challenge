package com.test.amaro.amarotest.dagger.modules;

import android.content.Context;
import android.content.SharedPreferences;
import com.test.amaro.amarotest.AmaroApplication;
import com.test.amaro.amarotest.dagger.scopes.ApplicationContext;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class ApplicationModule {

    private final AmaroApplication androidApplication;
    private static final String PREFERENCE = "preference";

    @Provides
    @Singleton
    public final AmaroApplication provideApplication() {
        return this.androidApplication;
    }

    @Provides
    @Singleton
    @ApplicationContext
    public final Context provideApplicationContext() {
        return this.androidApplication;
    }

    public ApplicationModule(AmaroApplication androidApplication) {
        this.androidApplication = androidApplication;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences() {
        return androidApplication.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
    }
}
