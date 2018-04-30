package com.amaro.bruno.amarochallenge.catalogue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amaro.bruno.amarochallenge.R;
import com.amaro.bruno.amarochallenge.catalogue.model.Product;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductsListAdapter extends BaseAdapter {

    private Context context;
    private List<Product> products;

    public ProductsListAdapter(Context context, List<Product> products){
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.product_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        final Product product = (Product) this.getItem(i);

        if(!"".equals(product.getImage())) {
            RequestOptions options = new RequestOptions()
                    .placeholder(android.R.color.white)
                    .error(R.drawable.no_image);

            Glide.with(context)
                    .load(product.getImage())
                    .apply(options)
                    .into(viewHolder.imgProduct);
        }

        viewHolder.tvProductName.setText(product.getName());
        viewHolder.tvPrice.setText(product.getRegularPrice());

        return view;
    }

    static class ViewHolder implements View.OnClickListener{

        @BindView(R.id.img_product)
        ImageView imgProduct;

        @BindView(R.id.tv_product_name)
        TextView tvProductName;

        @BindView(R.id.tv_price)
        TextView tvPrice;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }

        @Override
        @OnClick(R.id.card_item)
        public void onClick(View view) {
//            TODO open the Product details
        }
    }
}
