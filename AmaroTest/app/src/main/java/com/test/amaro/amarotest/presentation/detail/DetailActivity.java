package com.test.amaro.amarotest.presentation.detail;

import static android.view.View.GONE;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.test.amaro.amarotest.R;
import com.test.amaro.amarotest.models.Product;
import com.test.amaro.amarotest.models.Size;
import com.test.amaro.amarotest.presentation.core.BaseActivity;
import com.test.amaro.amarotest.presentation.detail.DetailContract.DetailView;
import java.util.List;
import javax.inject.Inject;

@SuppressWarnings("all")
public final class DetailActivity extends BaseActivity implements DetailView {

    @Inject
    DetailPresenter presenter;
    private TextView priceTextView;
    private TextView priceLabelTextView;
    private TextView installmentTextView;
    private TextView installmentLabelTextView;
    private TextView sizeLabelTextView;
    private ImageView productImageView;

    private Product getProduct() {
        return this.getIntent().getParcelableExtra(Product.TAG);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_detail);
        this.setupDagger();
        this.setupViews();
        this.setupPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    private void setupDagger() {
        this.getActivityComponent().inject(this);
    }

    private void setupPresenter() {
        presenter.attachView(this);
        presenter.loadProduct(this.getProduct());
    }

    private void setupViews() {
        this.productImageView = this.findViewById(R.id.image);
        this.priceTextView = this.findViewById(R.id.txt_price);
        this.priceLabelTextView = this.findViewById(R.id.lbl_price);
        this.installmentTextView = this.findViewById(R.id.txt_installments);
        this.installmentLabelTextView = this.findViewById(R.id.lbl_installments);
        this.sizeLabelTextView = this.findViewById(R.id.lbl_size);
    }

    public void setupToolbar(final String name) {
        final CollapsingToolbarLayout collapsingToolbar = this
                .findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(name);
        final Toolbar toolbar = findViewById(R.id.pinned_toolbar);
        this.setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        }
    }

    @Override
    public void showProductImage(final String url) {
        final Drawable imagePlaceHolderDrawable = ContextCompat
                .getDrawable(this, R.drawable.ic_account_circle_gray_100dp);

        Picasso.with(this)
                .load(url)
                .placeholder(imagePlaceHolderDrawable)
                .error(R.drawable.ic_cloud_off_grey_100dp)
                .into(productImageView);
    }

    @Override
    public void showProductImageEmptyState() {
        productImageView.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.ic_cloud_off_grey_100dp));
    }

    @Override
    public void showProductPrice(final String price) {
        this.priceTextView.setText(price);
    }

    @Override
    public void showProductPromotionalPrice(final String price, final String promotionalPrice) {
        this.priceLabelTextView.setText(getString(R.string.promotional_price));
        this.priceTextView
                .setText(getString(R.string.promotional_price_template, price, promotionalPrice));
    }

    @Override
    public void showProductInstallment(final String installment) {
        this.installmentTextView.setText(installment);
    }

    @Override
    public void hideProductInstallment() {
        this.installmentTextView.setVisibility(GONE);
        this.installmentLabelTextView.setVisibility(GONE);
    }

    @Override
    public void showProductUniqueSize(final List<Size> sizes) {
        this.sizeLabelTextView.setText(getString(R.string.size));
        this.showProductSizesRecyclerView(sizes);
    }

    @Override
    public void showProductSizesRecyclerView(List<Size> sizes) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        RecyclerView recyclerView = findViewById(R.id.rv_sizes);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setAdapter(new DetailAdapter(sizes));
    }

}
