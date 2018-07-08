package com.test.amaro.amarotest.dagger.components;

import com.test.amaro.amarotest.dagger.modules.ApplicationModule;
import com.test.amaro.amarotest.dagger.modules.NetworkModule;
import com.test.amaro.amarotest.dagger.modules.RepositoryModule;
import com.test.amaro.amarotest.dagger.modules.UseCaseModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class,
        RepositoryModule.class,
        UseCaseModule.class})
public interface ApplicationComponent {

    ActivityComponent activityComponent();

    DialogFragmentComponent dialogFragmentComponent();

}