package com.test.amaro.amarotest.presentation.detail;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.test.amaro.amarotest.R;
import com.test.amaro.amarotest.models.Size;
import java.util.List;

public final class DetailAdapter extends Adapter<DetailAdapter.ProductSizeViewHolder> {

    private final List<Size> sizes;

    public ProductSizeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.size, parent, false);
        return new ProductSizeViewHolder(view);
    }

    public void onBindViewHolder(ProductSizeViewHolder holder, int position) {
        holder.bind(this.sizes.get(position));
    }

    public int getItemCount() {
        return this.sizes.size();
    }

    DetailAdapter(List<Size> sizes) {
        this.sizes = sizes;
    }

    final class ProductSizeViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {

        final void bind(Size size) {
            final TextView txtSize = this.itemView.findViewById(R.id.txt_size);
            txtSize.setText(size.getSize());
        }

        ProductSizeViewHolder(View view) {
            super(view);
        }
    }
}
