package com.test.amaro.amarotest.dagger.modules

import android.content.Context
import com.test.amaro.amarotest.dagger.scopes.ApplicationContext
import com.test.amaro.amarotest.AmaroApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
class ApplicationModule constructor(private val androidApplication: AmaroApplication) {

    @Provides
    @Singleton
    internal fun provideApplication(): AmaroApplication {
        return androidApplication
    }

    @Provides
    @Singleton
    @ApplicationContext
    internal fun provideApplicationContext(): Context {
        return androidApplication
    }

}
