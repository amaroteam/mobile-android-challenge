package com.amaro.bruno.amarochallenge.catalogue.products.remote;

import android.content.Context;

import com.amaro.bruno.amarochallenge.AppConstants;
import com.amaro.bruno.amarochallenge.catalogue.products.model.ProductList;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface RestApi {

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET(AppConstants.URL_PRODUCTS)
    Observable<Response<ProductList>> getProducts();

    class Builder {
        private static HttpLoggingInterceptor getLoggingInterceptor() {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            return interceptor;
        }

        public static OkHttpClient getOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
            return new OkHttpClient.Builder()
                    .dispatcher(new Dispatcher(Executors.newFixedThreadPool(AppConstants.NUMBER_OF_THREADS)))
                    .addInterceptor(httpLoggingInterceptor)
                    .readTimeout(AppConstants.TIMEOUT, TimeUnit.SECONDS)
                    .connectTimeout(AppConstants.TIMEOUT, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();
        }

        /**
         * @return RestApi
         */
        public static RestApi build() {

            OkHttpClient client = getOkHttpClient(getLoggingInterceptor());

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(JacksonConverterFactory.create())
                    .client(client)
                    .build();

            return retrofit.create(RestApi.class);
        }
    }

}
