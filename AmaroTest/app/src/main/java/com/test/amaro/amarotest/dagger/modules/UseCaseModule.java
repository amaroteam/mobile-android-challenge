package com.test.amaro.amarotest.dagger.modules;

import android.content.SharedPreferences;
import com.test.amaro.amarotest.data.repository.ProductRepository;
import com.test.amaro.amarotest.data.usecases.ProductUseCase;
import com.test.amaro.amarotest.data.usecases.ProductUseCaseImpl;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class UseCaseModule {

    @Provides
    @Singleton
    public final ProductUseCase provideProductUseCase(ProductRepository productRepository,
            SharedPreferences sharedPreferences) {
        return new ProductUseCaseImpl(productRepository, sharedPreferences) {
        };
    }
}
