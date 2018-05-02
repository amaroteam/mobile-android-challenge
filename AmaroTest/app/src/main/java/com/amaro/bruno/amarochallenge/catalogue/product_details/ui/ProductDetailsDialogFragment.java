package com.amaro.bruno.amarochallenge.catalogue.product_details.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amaro.bruno.amarochallenge.R;
import com.amaro.bruno.amarochallenge.catalogue.product_details.di.InjectionProductDetailsPresenter;
import com.amaro.bruno.amarochallenge.catalogue.product_details.di.InjectionStrikethroughSpan;
import com.amaro.bruno.amarochallenge.catalogue.product_details.listener.ISizeChangedListener;
import com.amaro.bruno.amarochallenge.catalogue.product_details.presentation.ProductDetailsContract;
import com.amaro.bruno.amarochallenge.catalogue.products.model.Product;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ProductDetailsDialogFragment extends DialogFragment implements ISizeChangedListener {

    public static final String TAG = ProductDetailsDialogFragment.class.getName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.coordinator_details)
    CoordinatorLayout coordinatorDetails;

    @BindView(R.id.img_product)
    ImageView imgProduct;

    @BindView(R.id.tv_product_name)
    TextView tvProductName;

    @BindView(R.id.tv_promotion)
    TextView tvPromotion;

    @BindView(R.id.tv_actual_price)
    TextView tvActualPrice;

    @BindView(R.id.tv_regular_price)
    TextView tvRegularPrice;

    @BindView(R.id.tv_installments)
    TextView tvInstallments;

    @BindView(R.id.tv_size_unique)
    TextView tvSizeUnique;

    @BindView(R.id.tv_size_very_big)
    TextView tvSizeVeryBig;

    @BindView(R.id.tv_size_big)
    TextView tvSizeBig;

    @BindView(R.id.tv_size_medium)
    TextView tvSizeMedium;

    @BindView(R.id.tv_size_small)
    TextView tvSizeSmall;

    @BindView(R.id.tv_size_very_small)
    TextView tvSizeVerySmall;

    private Unbinder unbinder;
    private Bundle args;
    private Product product;
    private ProductDetailsContract.Presenter detailsPresenter;
    private static final StrikethroughSpan STRIKE_THROUGH_SPAN = InjectionStrikethroughSpan.inject();

    public static ProductDetailsDialogFragment newInstance(){
        return new ProductDetailsDialogFragment();
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(R.layout.product_details_dialog_fragment, null, false);
        unbinder = ButterKnife.bind(this, view);

        args = getArguments();

        detailsPresenter = InjectionProductDetailsPresenter.inject(getActivity());

        toolbar.setNavigationIcon(R.drawable.clear);
        toolbar.setNavigationOnClickListener(v -> dismiss());

        if(args != null){
            product = args.getParcelable(Product.BUNDLE);

            if(product != null){
                toolbar.setTitle(product.getName());

                RequestOptions options = new RequestOptions()
                        .placeholder(android.R.color.white)
                        .error(R.drawable.no_image);

                Glide.with(getActivity())
                        .load(product.getImage())
                        .apply(options)
                        .into(imgProduct);

                tvProductName.setText(product.getName());

                if(detailsPresenter.hasDiscountPercent(product)){
                    tvPromotion.setVisibility(View.VISIBLE);
                    tvPromotion.setText(getString(R.string.discount_percentage, product.getDiscountPercent()));

                    tvActualPrice.setVisibility(View.VISIBLE);
                    tvActualPrice.setText(product.getActualPrice());

                    tvRegularPrice.setText(product.getRegularPrice(), TextView.BufferType.SPANNABLE);
                    Spannable spannable = (Spannable) tvRegularPrice.getText();
                    spannable.setSpan(STRIKE_THROUGH_SPAN, 0, product.getRegularPrice().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                else{
                    tvRegularPrice.setText(product.getRegularPrice());
                }

                tvInstallments.setText(product.getInstallments());

                detailsPresenter.loadSizes(product.getSizes(), this);
            }
        }

        return initiateAlertDialog(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        }
    }

    @OnClick(R.id.bt_buy)
    public void buyClick(){
        Snackbar.make(coordinatorDetails, "This functionality is not covered", Snackbar.LENGTH_LONG).show();
    }

    public void onDestroyView(){
        super.onDestroyView();
        unbinder.unbind();
    }

    private AlertDialog initiateAlertDialog(View view){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.Theme_AppCompat_Dialog_Alert);
        builder.setView(view);

        AlertDialog alert = builder.create();

        alert.setOnShowListener(dialog -> alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(getActivity(), android.R.color.black)));

        return alert;
    }

    @Override
    public void onSizeVeryBig(String sizeVeryBig) {
        tvSizeVeryBig.setVisibility(View.VISIBLE);
        tvSizeVeryBig.setText(sizeVeryBig);
    }

    @Override
    public void onSizeBig(String sizeBig) {
        tvSizeBig.setVisibility(View.VISIBLE);
        tvSizeBig.setText(sizeBig);
    }

    @Override
    public void onSizeMedium(String sizeMedium) {
        tvSizeMedium.setVisibility(View.VISIBLE);
        tvSizeMedium.setText(sizeMedium);
    }

    @Override
    public void onSizeSmall(String sizeSmall) {
        tvSizeSmall.setVisibility(View.VISIBLE);
        tvSizeSmall.setText(sizeSmall);
    }

    @Override
    public void onSizeVerySmall(String sizeVerySmall) {
        tvSizeVerySmall.setVisibility(View.VISIBLE);
        tvSizeVerySmall.setText(sizeVerySmall);
    }

    @Override
    public void onSizeUnique(String sizeUnique) {
        tvSizeUnique.setVisibility(View.VISIBLE);
        tvSizeUnique.setText(sizeUnique);
    }
}
