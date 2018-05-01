package com.amaro.bruno.amarochallenge.catalogue.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.amaro.bruno.amarochallenge.R;
import com.amaro.bruno.amarochallenge.catalogue.adapter.DialogSearchAdapter;
import com.amaro.bruno.amarochallenge.catalogue.listener.IOptionPriceSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SearchDialogFragment extends DialogFragment implements IOptionPriceSelectListener {

    public static final String TAG = SearchDialogFragment.class.getName();

    public static final String BUNDLE_SEARCH_OPTION = "search_option";

    public static final String SEARCH_PRICE = "search_price";

    public static final String BUNDLE_PRICES = "prices";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recycler_options)
    RecyclerView recyclerOptions;

    private Unbinder unbinder;
    private Bundle args;
    private String searchOption;
    private List<String> prices = new ArrayList<>();
    private List<String> sizes = new ArrayList<>();
    private IOptionPriceSelectListener optionPriceSelectListener;
    private DialogSearchAdapter adapter;

    public static SearchDialogFragment newInstance(){
        return new SearchDialogFragment();
    }

    public void setOptionPriceSelectListener(IOptionPriceSelectListener optionPriceSelectListener){
        this.optionPriceSelectListener = optionPriceSelectListener;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(R.layout.dialog_search, null, false);
        unbinder = ButterKnife.bind(this, view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerOptions.setLayoutManager(layoutManager);

        toolbar.setNavigationIcon(R.drawable.clear);
        toolbar.setNavigationOnClickListener(v -> dismiss());

        args = getArguments();

        if(args != null){
            searchOption = args.getString(BUNDLE_SEARCH_OPTION);
            prices = args.getStringArrayList(BUNDLE_PRICES);

            if(searchOption != null) {
                if (searchOption.equals(SEARCH_PRICE)){
                    toolbar.setTitle("Price");
                    adapter = new DialogSearchAdapter(prices);
                    adapter.setOptionPriceSelectListener(this);
                    recyclerOptions.setAdapter(adapter);
                }
            }
        }

        return initiateAlertDialog(view);
    }

    @Override
    public int getTheme() {
        return R.style.DialogAnimation;
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
    public void onPriceSelected(String price) {
        dismiss();
        optionPriceSelectListener.onPriceSelected(price);
    }
}
