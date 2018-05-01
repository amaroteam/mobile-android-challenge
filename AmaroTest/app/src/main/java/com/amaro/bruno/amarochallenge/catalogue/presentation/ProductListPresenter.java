package com.amaro.bruno.amarochallenge.catalogue.presentation;

import android.content.Context;

import com.amaro.bruno.amarochallenge.R;
import com.amaro.bruno.amarochallenge.catalogue.adapter.ProductsListAdapter;
import com.amaro.bruno.amarochallenge.catalogue.extensions.StringUtils;
import com.amaro.bruno.amarochallenge.catalogue.model.Product;
import com.amaro.bruno.amarochallenge.catalogue.model.Size;
import com.amaro.bruno.amarochallenge.catalogue.use_case.ProductsListFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

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
    public void getProductsList() {
//        TODO Call the API using RxJava and Retrofit
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
