package com.test.amaro.amarotest.dagger.components;

import android.content.Context;
import com.test.amaro.amarotest.AmaroApplication;
import com.test.amaro.amarotest.dagger.modules.ApplicationModule;
import com.test.amaro.amarotest.dagger.modules.NetworkModule;
import com.test.amaro.amarotest.dagger.modules.RepositoryModule;
import com.test.amaro.amarotest.dagger.scopes.ApplicationContext;
import dagger.Component;
import javax.inject.Singleton;

@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = { ApplicationModule.class, NetworkModule.class, RepositoryModule.class } )
public interface ApplicationComponent {

    AmaroApplication amaroApplication();

    ActivityComponent activityComponent();

    @ApplicationContext
    Context context();
}