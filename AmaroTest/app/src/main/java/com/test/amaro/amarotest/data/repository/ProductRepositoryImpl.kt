package com.test.amaro.amarotest.data.repository

import com.test.amaro.amarotest.data.ProductService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProductRepositoryImpl
@Inject constructor(val service: ProductService) : ProductRepository {

    override fun loadProducts() = service.getProducts()
        .map { example -> example.products }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())!!
}