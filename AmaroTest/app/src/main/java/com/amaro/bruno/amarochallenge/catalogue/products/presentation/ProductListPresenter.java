package com.amaro.bruno.amarochallenge.catalogue.products.presentation;

import android.content.Context;
import android.util.Log;

import com.amaro.bruno.amarochallenge.AppConstants;
import com.amaro.bruno.amarochallenge.R;
import com.amaro.bruno.amarochallenge.BasePresenter;
import com.amaro.bruno.amarochallenge.catalogue.products.di.InjectionRestApi;
import com.amaro.bruno.amarochallenge.catalogue.products.model.ProductList;
import com.amaro.bruno.amarochallenge.catalogue.products.ui.adapter.ProductsListAdapter;
import com.amaro.bruno.amarochallenge.catalogue.products.extensions.StringUtils;
import com.amaro.bruno.amarochallenge.catalogue.products.model.Product;
import com.amaro.bruno.amarochallenge.catalogue.products.model.Size;
import com.amaro.bruno.amarochallenge.catalogue.products.use_case.ProductsListFilter;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

public class ProductListPresenter extends BasePresenter<ProductListContract.View>
        implements ProductListContract.Presenter {

    private Context context;

    public ProductListPresenter(ProductListContract.View view) {
        super(view);
    }

    public void setContext(Context context){
        this.context = context;
    }

    @Override
    public void getProductsList(Scheduler scheduler, Scheduler observer) {
        view.showProgress();

        InjectionRestApi.inject()
                .getProducts()
                .subscribeOn(scheduler)
                .observeOn(observer)
                .subscribe(new Observer<Response<ProductList>>() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onNext(Response<ProductList> productListResponse) {
                        if(productListResponse.isSuccessful()){
                            if(productListResponse.body() != null) {
                                view.onSuccessListProducts(Objects.requireNonNull(productListResponse.body()).getProducts());
                            }
                        }
                        else{
                            if(productListResponse.errorBody() != null) {
                                try {
                                    Log.d("Error", Objects.requireNonNull(productListResponse.errorBody()).string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            else{
                                view.onError(context.getString(R.string.general_error));
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.hideProgress();

                        if(e != null)
                            Log.e("onError", e.getMessage());

                        if (e instanceof SocketTimeoutException) {
                            view.onError(context.getString(R.string.timeout_error));
                        } else {
                            view.onError(context.getString(R.string.general_error));
                        }
                    }

                    @Override
                    public void onComplete() {
                        view.hideProgress();
                    }
                });
    }

    @Override
    public List<String> getSizes(Product product){
        List<String> sizes = new ArrayList<>();

        for(Size size : product.getSizes()){
            sizes.add(size.getSize());
        }

        return sizes;
    }

    public ArrayList<String> getPrices(){
        ArrayList<String> prices = new ArrayList<>();

        prices.add(context.getString(R.string.all));
        prices.add(context.getString(R.string.between_50_100));
        prices.add(context.getString(R.string.between_100_200));
        prices.add(context.getString(R.string.higher_200));

        return prices;
    }

    @Override
    public List<Product> getProductsBySize(List<Product> products, String size) {
        if(products != null && products.size() > 0){
            return products.stream()
                    .filter(Product::isOnSale)
                    .filter(product -> {
                        for(Size auxSize : product.getSizes()){
                            if(auxSize.getSize().toLowerCase().equals(size.toLowerCase())){
                                return true;
                            }
                        }

                        return false;
                    })
                    .collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public List<Product> getProductsByPriceRange(List<Product> products, double initialPrice, double finalPrice){
        if(products != null && products.size() > 0){
            return products.stream()
                    .filter(Product::isOnSale)
                    .filter(product -> StringUtils.convertCurrencyToDouble(product.getRegularPrice()) >= initialPrice //TODO create an extension function to convert any currency to a double
                                        && StringUtils.convertCurrencyToDouble(product.getRegularPrice()) <= finalPrice)
                    .collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public List<Product> getProductsHigherThan(List<Product> products, double val){
        if(products != null && products.size() > 0){
            return products.stream()
                    .filter(product -> StringUtils.convertCurrencyToDouble(product.getRegularPrice()) > val)
                    .collect(Collectors.toList());
        }

        return null;
    }

    public List<Product> filterProductsAdapter(ProductsListAdapter productsAdapter, List<Product> allProducts, ProductsListFilter filter){
        List<Product> filtered = new ArrayList<>();

        if(filter.getPrice() == null || context.getString(R.string.all).equals(filter.getPrice())){
            productsAdapter.replaceAll(allProducts);
            return allProducts;
        }

        if(context.getString(R.string.between_50_100).equals(filter.getPrice())){
            filtered = getProductsByPriceRange(allProducts, 50, 100);
        }

        if(context.getString(R.string.between_100_200).equals(filter.getPrice())){
            filtered = getProductsByPriceRange(allProducts, 100, 200);
        }

        if(context.getString(R.string.higher_200).equals(filter.getPrice())){
            filtered = getProductsHigherThan(allProducts, 200);
        }

        productsAdapter.replaceAll(filtered);

        return filtered;
    }
}
