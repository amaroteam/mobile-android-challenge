package com.test.amaro.amarotest.data.repository

import com.test.amaro.amarotest.models.Product
import io.reactivex.Observable

interface ProductRepository {

    fun loadProducts() : Observable<List<Product>>
}
