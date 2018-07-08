package com.test.amaro.amarotest.dagger.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.test.amaro.amarotest.AmaroApplication;
import com.test.amaro.amarotest.BuildConfig;
import com.test.amaro.amarotest.data.ProductService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public final class NetworkModule {

    @Provides
    @Singleton
    public final Cache provideOkHttpCache(AmaroApplication application) {
        int cacheSize = 10 * 1024 * 1024;
        return new Cache(application.getCacheDir(), (long) cacheSize);
    }

    @Provides
    @Singleton
    public final Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    public final OkHttpClient provideOkHttpClient(Cache cache) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(Level.BODY);
        Builder builder = new Builder();
        builder.addInterceptor((httpLoggingInterceptor));
        builder.cache(cache);
        return builder.build();
    }

    @Provides
    @Singleton
    public final Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient).build();
    }

    @Provides
    @Singleton
    public final ProductService provideService(Retrofit retrofit) {
        return retrofit.create(ProductService.class);
    }
}
