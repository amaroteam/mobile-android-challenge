package com.amaro.bruno.amarochallenge.catalogue.ui;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.amaro.bruno.amarochallenge.BaseActivity;
import com.amaro.bruno.amarochallenge.R;
import com.amaro.bruno.amarochallenge.catalogue.adapter.ProductsListAdapter;
import com.amaro.bruno.amarochallenge.catalogue.di.InjectionProductsListAdapter;
import com.amaro.bruno.amarochallenge.catalogue.extensions.ViewUtils;
import com.amaro.bruno.amarochallenge.catalogue.model.Product;
import com.amaro.bruno.amarochallenge.catalogue.presentation.ProductListContract;
import com.amaro.bruno.amarochallenge.catalogue.presentation.ProductListPresenter;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class ProductsListActivity extends BaseActivity implements ProductListContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.search_view)
    MaterialSearchView searchView;

    @BindView(R.id.linear_filter)
    LinearLayout linearFilter;

    @BindView(R.id.grid_products)
    GridView gridProducts;

    @Inject
    ProductListPresenter productListPresenter;

    private ProductsListAdapter productsAdapter;
    private int myLastVisiblePos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        ButterKnife.bind(this);
        AndroidInjection.inject(this);

        setup();

        productListPresenter.getProductsList();

        gridProducts.setAdapter(productsAdapter);
        gridProducts.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) { }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                int currentFirstVisPos = absListView.getFirstVisiblePosition();
                if(currentFirstVisPos > myLastVisiblePos) {
                    ViewUtils.hideViewOnScrollDownWithAnimation(linearFilter);
                }
                if(currentFirstVisPos < myLastVisiblePos) {
                    ViewUtils.showViewOnScrollUpWithAnimation(linearFilter);
                }

                myLastVisiblePos = currentFirstVisPos;
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        productListPresenter.stop();
    }

    @Override
    protected void setup() {
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(R.string.app_name);
        }

        searchView.setVoiceSearch(true);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("Query", query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        productsAdapter = InjectionProductsListAdapter.getProductsListAdapter(this,
                Arrays.asList(
                        new Product("VESTIDO TRANSPASSE BOW", "R$ 199,90", "https://d3l7rqep7l31az.cloudfront.net/images/products/20002605_615_catalog_1.jpg?1460136912"),
                        new Product("REGATA ALCINHA FOLK", "R$ 99,90", "https://d3l7rqep7l31az.cloudfront.net/images/products/20002570_002_catalog_1.jpg?1459948578"),
                        new Product("TOP CROPPED SUEDE", "R$ 129,90", "https://d3l7rqep7l31az.cloudfront.net/images/products/20002575_027_catalog_1.jpg?1459537946"),
                        new Product("BATA DECOTE FLUID", "R$ 149,90", "https://d3l7rqep7l31az.cloudfront.net/images/products/20002581_614_catalog_1.jpg?1459536611"),
                        new Product("T-SHIRT LEATHER DULL", "R$ 139,90", ""),
                        new Product("CAMISA SUEDE SPAN", "R$ 189,90", "https://d3l7rqep7l31az.cloudfront.net/images/products/20002584_035_catalog_1.jpg?1459947139"),
                        new Product("CALÇA CLASSIC PRINT", "R$ 159,90", "https://d3l7rqep7l31az.cloudfront.net/images/products/20002634_613_catalog_1.jpg?1459548109"),
                        new Product("REGATA ALCINHA FOLK", "R$ 99,90", "https://d3l7rqep7l31az.cloudfront.net/images/products/20002570_029_catalog_1.jpg?1459948578")));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.products_list_menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
//                TODO search functionality
                return true;
        }

        return false;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onSuccessListProducts(ArrayList<Product> products) {

    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onBackPressed() {
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }
}
