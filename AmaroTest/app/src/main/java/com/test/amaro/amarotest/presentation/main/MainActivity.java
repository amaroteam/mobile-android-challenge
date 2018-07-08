package com.test.amaro.amarotest.presentation.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.test.amaro.amarotest.R;
import com.test.amaro.amarotest.presentation.core.BaseActivity;
import com.test.amaro.amarotest.presentation.detail.DetailActivity;
import com.test.amaro.amarotest.presentation.main.MainContract.MainView;
import com.test.amaro.amarotest.models.Product;
import java.util.List;
import javax.inject.Inject;

public final class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainPresenter presenter;
    private MainAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.setupDagger();
        this.setupSwipeRefresh();
        this.setupPresenter();
        this.setupAdapter();
        this.setupRecyclerView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.detachView();
    }

    private void setupDagger() {
        this.getActivityComponent().inject(this);
    }

    private void setupSwipeRefresh() {
        this.swipeRefreshLayout = findViewById(R.id.swiperefresh);
        this.swipeRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                retry();
            }
        });
    }

    private void setupRecyclerView() {
        RecyclerView bestSellersRecyclerView = findViewById(R.id.best_sellers_recycler_view);
        bestSellersRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        bestSellersRecyclerView.setAdapter(adapter);
    }

    private void setupPresenter() {
        this.presenter.attachView(this);
        this.presenter.loadProducts();
    }

    private void setupAdapter() {
        this.adapter = new MainAdapter(this, new OnProductClickListener() {
            @Override
            public void onProductClick(Product product) {
                final Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(Product.TAG, product);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showProducts(List<Product> products) {
        this.adapter.setProducts(products);
    }

    @Override
    public void onLoadStarted() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onLoadFinished() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void retry() {
        this.presenter.loadProducts();
    }

    @Override
    public void onShowError(final String error) {
        Snackbar.make(findViewById(android.R.id.content), getString(R.string.error_message), Snackbar.LENGTH_INDEFINITE)
                .setAction(this.getString(R.string.retry_text),
                        new android.view.View.OnClickListener() {
                            public final void onClick(android.view.View it) {
                                MainActivity.this.retry();
                            }
                        }).show();
    }

    public interface OnProductClickListener {
        void onProductClick(final Product product);
    }

}
