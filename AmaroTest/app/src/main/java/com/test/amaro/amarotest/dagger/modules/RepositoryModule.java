package com.test.amaro.amarotest.dagger.modules;

import android.support.annotation.NonNull;
import com.test.amaro.amarotest.data.ProductService;
import com.test.amaro.amarotest.data.repository.ProductRepository;
import com.test.amaro.amarotest.data.repository.ProductRepositoryImpl;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class RepositoryModule {

    @NonNull
    @Provides
    @Singleton
    public final ProductRepository provideProductRepository(ProductService service) {
        return new ProductRepositoryImpl(service);
    }
}
