package com.test.amaro.amarotest.dagger.components

import com.test.amaro.amarotest.dagger.modules.PresenterModule
import com.test.amaro.amarotest.dagger.scopes.PerActivity
import com.test.amaro.amarotest.main.MainActivity
import dagger.Subcomponent


/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = arrayOf(PresenterModule::class))
interface ActivityComponent {

  fun inject(mainActivity: MainActivity)

}