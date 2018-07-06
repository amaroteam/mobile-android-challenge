package com.test.amaro.amarotest.dagger.components

import android.content.Context
import com.test.amaro.amarotest.dagger.scopes.ApplicationContext
import com.test.amaro.amarotest.AmaroApplication
import com.test.amaro.amarotest.dagger.modules.ApplicationModule
import com.test.amaro.amarotest.dagger.modules.NetworkModule
import com.test.amaro.amarotest.dagger.modules.RepositoryModule
import dagger.Component
import javax.inject.Singleton

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class, RepositoryModule::class))
interface ApplicationComponent {

    fun amaroApplication(): AmaroApplication

    fun activityComponent(): ActivityComponent

    @ApplicationContext
    fun context(): Context
}
