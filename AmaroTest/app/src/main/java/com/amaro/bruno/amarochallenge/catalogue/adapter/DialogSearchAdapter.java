package com.amaro.bruno.amarochallenge.catalogue.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amaro.bruno.amarochallenge.R;
import com.amaro.bruno.amarochallenge.catalogue.listener.IOptionPriceSelectListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogSearchAdapter extends RecyclerView.Adapter<DialogSearchAdapter.ViewHolder> {

    private List<String> items;
    private IOptionPriceSelectListener optionPriceSelectListener;

    public DialogSearchAdapter(List<String> items){
        this.items = items;
    }

    public void setOptionPriceSelectListener(IOptionPriceSelectListener optionPriceSelectListener){
        this.optionPriceSelectListener = optionPriceSelectListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.spinner_item, parent, false);

        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = items.get(position);

        holder.tvText.setText(item);
        holder.tvText.setOnClickListener(view -> {
            if(optionPriceSelectListener != null){
                optionPriceSelectListener.onPriceSelected(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_text)
        TextView tvText;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
