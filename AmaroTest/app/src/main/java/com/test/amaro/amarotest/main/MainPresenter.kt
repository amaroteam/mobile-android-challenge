package com.test.amaro.amarotest.main

import com.test.amaro.amarotest.data.repository.ProductRepository
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

open class MainPresenter
@Inject
constructor(var amaroRepository: ProductRepository) : MainContract.Presenter() {

    override fun getProducts() {
        addDisposable(amaroRepository.loadProducts()
            .subscribeBy(
                onNext = { view.showProducts(it) },
                onError = { view.onShowError("Failed to get repositories"); view.onLoadFinished() },
                onComplete = { view.onLoadFinished() }
            ))
    }
}