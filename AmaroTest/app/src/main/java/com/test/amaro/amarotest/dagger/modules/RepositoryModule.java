package com.test.amaro.amarotest.dagger.modules;

import com.test.amaro.amarotest.data.ProductService;
import com.test.amaro.amarotest.data.repository.ProductRepository;
import com.test.amaro.amarotest.data.repository.ProductRepositoryImpl;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class RepositoryModule {

    @Provides
    @Singleton
    public final ProductRepository provideProductRepository(ProductService service) {
        return new ProductRepositoryImpl(service);
    }
}
