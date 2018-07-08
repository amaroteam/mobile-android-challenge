package com.test.amaro.amarotest.dagger.modules;

import android.content.Context;
import com.test.amaro.amarotest.AmaroApplication;
import com.test.amaro.amarotest.dagger.scopes.ApplicationContext;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class ApplicationModule {

    private final AmaroApplication androidApplication;

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
}
