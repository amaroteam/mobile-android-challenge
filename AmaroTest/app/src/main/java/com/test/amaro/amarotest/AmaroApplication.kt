package com.test.amaro.amarotest

import android.app.Application
import com.test.amaro.amarotest.dagger.components.ApplicationComponent
import com.test.amaro.amarotest.dagger.components.DaggerApplicationComponent
import com.test.amaro.amarotest.dagger.modules.ApplicationModule

class AmaroApplication : Application() {

  companion object {

    @JvmStatic lateinit var applicationComponent: ApplicationComponent

  }

  override fun onCreate() {
    super.onCreate()
    initDagger()
  }

  private fun initDagger() {
    applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(ApplicationModule(this))
        .build()
  }


}