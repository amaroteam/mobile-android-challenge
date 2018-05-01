package com.amaro.bruno.amarochallenge.catalogue.products.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.amaro.bruno.amarochallenge.R;
import com.amaro.bruno.amarochallenge.catalogue.products.model.Product;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductsListAdapter extends BaseAdapter implements Filterable {

    private Context context;
    private List<Product> products;
    private List<Product> productsAux;
    private ProductItemClickListener productItemClickListener;

    public ProductsListAdapter(Context context, List<Product> products, ProductItemClickListener productItemClickListener){
        this.context = context;
        this.products = products;
        this.productsAux = products;
        this.productItemClickListener = productItemClickListener;
    }

    public void clear(){
        products.clear();
    }

    public void replaceAll(List<Product> products){
        clear();
        this.products.addAll(products);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return productsAux.size();
    }

    @Override
    public Object getItem(int i) {
        return productsAux.get(i);
    }

    public List<Product> getItems(){
        return products;
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

        viewHolder.bind(product);

        RequestOptions options = new RequestOptions()
                .placeholder(android.R.color.white)
                .error(R.drawable.no_image);

        Glide.with(context)
                .load(product.getImage())
                .apply(options)
                .into(viewHolder.imgProduct);

        viewHolder.tvProductName.setText(product.getName());
        viewHolder.tvPrice.setText(product.getRegularPrice());

        return view;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results.count != 0) {
                    productsAux = (List<Product>) results.values;
                    notifyDataSetChanged();
                }
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults results = new FilterResults();
                List<Product> filteredArray = new ArrayList<>();

                if (constraint == null || constraint.length() == 0) {
                    // No filter implemented we return all the list
                    results.values = products;
                    results.count = products.size();
                } else {

                    constraint = constraint.toString().toLowerCase();
                    for (Product product : products) {
                        String productName = product.getName();
                        if (productName.toLowerCase().contains(constraint.toString())) {
                            filteredArray.add(product);
                        }
                    }

                    results.count = filteredArray.size();
                    results.values = filteredArray;
                }
                return results;
            }
        };
    }

    class ViewHolder implements View.OnClickListener{

        @BindView(R.id.img_product)
        ImageView imgProduct;

        @BindView(R.id.tv_product_name)
        TextView tvProductName;

        @BindView(R.id.tv_price)
        TextView tvPrice;

        Product product;

        private ViewHolder(View view){
            ButterKnife.bind(this, view);
        }

        void bind(Product product){
            this.product = product;
        }

        @Override
        @OnClick(R.id.card_item)
        public void onClick(View view) {
            productItemClickListener.onProductItemClicked(product);
        }
    }
}
