package com.test.amaro.amarotest.dagger.components;

import com.test.amaro.amarotest.dagger.modules.PresenterModule;
import com.test.amaro.amarotest.dagger.scopes.PerActivity;
import com.test.amaro.amarotest.presentation.main.filter.FilterDialogFragment;
import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = PresenterModule.class)
public interface DialogFragmentComponent {

    void inject(FilterDialogFragment filterDialogFragment);
}
