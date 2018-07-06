package com.test.amaro.amarotest.data

import com.test.amaro.amarotest.models.Example
import io.reactivex.Observable
import retrofit2.http.GET

interface ProductService {

    @GET("v2/59b6a65a0f0000e90471257d")
    fun getProducts(): Observable<Example>
}
