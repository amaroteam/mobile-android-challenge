package com.test.amaro.amarotest.presentation.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.test.amaro.amarotest.R;
import com.test.amaro.amarotest.models.Product;
import com.test.amaro.amarotest.presentation.main.MainActivity.OnProductClickListener;
import com.test.amaro.amarotest.presentation.main.MainAdapter.ProductViewHolder;
import java.util.ArrayList;
import java.util.List;

public final class MainAdapter extends Adapter<ProductViewHolder> {

    private final List<Product> products;
    private final Context context;
    private final OnProductClickListener itemClickListener;

    public final void setProducts(final List<Product> list) {
        this.products.clear();
        this.products.addAll(list);
        this.notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.products.size();
    }

    public MainAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new MainAdapter.ProductViewHolder(view, this.itemClickListener);
    }

    public void onBindViewHolder(MainAdapter.ProductViewHolder holder, int position) {
        holder.bind(this.products.get(position));
    }

    MainAdapter(final Context context, final OnProductClickListener itemClickListener) {
        this.context = context;
        this.itemClickListener = itemClickListener;
        this.products = new ArrayList<>();
    }

    final class ProductViewHolder extends ViewHolder {

        private final OnProductClickListener itemClickListener;

        final void bind(final Product item) {

            final TextView txtName = this.itemView.findViewById(R.id.text_name);
            final TextView txtPrice = this.itemView.findViewById(R.id.text_price);
            final ImageView image = this.itemView.findViewById(R.id.image);

            txtName.setText(item.getName());
            txtPrice.setText(item.getActualPrice());
            setProductImage(item, image);

            this.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onProductClick(item);
                }
            });
        }

        private void setProductImage(Product item, ImageView image) {

            if (item.getImage().length() > 0) {
                final Drawable imagePlaceHolderDrawable = ContextCompat
                        .getDrawable(context, R.drawable.ic_account_circle_gray_100dp);
                Picasso.with(context).load(item.getImage())
                        .placeholder(imagePlaceHolderDrawable)
                        .into(image);
            } else {
                image.setScaleType(ScaleType.CENTER_INSIDE);
                image.setImageDrawable(
                        ContextCompat.getDrawable(context, R.drawable.ic_cloud_off_grey_100dp));
            }
        }

        ProductViewHolder(View view, OnProductClickListener itemClickListener) {

            super(view);
            this.itemClickListener = itemClickListener;
        }
    }
}
