package com.test.amaro.amarotest.main

import com.test.amaro.amarotest.core.BaseMvpPresenter
import com.test.amaro.amarotest.core.MvpView
import com.test.amaro.amarotest.models.Product

object MainContract {

    interface View : MvpView {

        fun retry()
        fun onLoadStarted()
        fun onLoadFinished()
        fun showProducts(products: List<Product>)
    }

    abstract class Presenter : BaseMvpPresenter<View>() {

        abstract fun getProducts()
    }
}