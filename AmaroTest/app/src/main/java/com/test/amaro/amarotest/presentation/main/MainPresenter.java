package com.test.amaro.amarotest.presentation.main;

import com.test.amaro.amarotest.data.usecases.ProductUseCase;
import com.test.amaro.amarotest.models.Product;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.List;
import javax.inject.Inject;

public final class MainPresenter extends MainContract.Presenter {

    private ProductUseCase productUseCase;

    @Inject
    public MainPresenter(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    public void loadProducts() {

        this.getView().onLoadStarted();

        productUseCase.loadProducts()
                .subscribe(new Observer<List<Product>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        addDisposable(disposable);
                    }

                    @Override
                    public void onNext(List<Product> products) {
                        getView().showProducts(products);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().onShowError(e.getMessage());
                        getView().onLoadFinished();
                    }

                    @Override
                    public void onComplete() {
                        getView().onLoadFinished();
                    }
                });
    }

}
