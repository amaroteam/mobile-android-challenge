package com.amaro.bruno.amarochallenge.catalogue.products.di;

import com.amaro.bruno.amarochallenge.catalogue.products.remote.RestApi;

public class InjectionRestApi {

    public static RestApi inject(){
        return RestApi.Builder.build();
    }

}
