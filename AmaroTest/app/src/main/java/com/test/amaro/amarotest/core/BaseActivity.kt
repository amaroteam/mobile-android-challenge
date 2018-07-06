package com.test.amaro.amarotest.core

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.test.amaro.amarotest.AmaroApplication
import com.test.amaro.amarotest.dagger.components.ActivityComponent

open class BaseActivity : AppCompatActivity() {

  protected var activityComponent: ActivityComponent = AmaroApplication.applicationComponent.activityComponent()

    @Suppress("UsePropertyAccessSyntax")
    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
    }

}
