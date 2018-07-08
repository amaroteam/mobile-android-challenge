package com.test.amaro.amarotest.dagger.components;

import com.test.amaro.amarotest.dagger.modules.PresenterModule;
import com.test.amaro.amarotest.dagger.scopes.PerActivity;
import com.test.amaro.amarotest.presentation.detail.DetailActivity;
import com.test.amaro.amarotest.presentation.main.MainActivity;
import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = PresenterModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
    void inject(DetailActivity detailActivity);
}
