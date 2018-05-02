package com.amaro.bruno.amarochallenge.catalogue.products.ui;

import android.widget.Filterable;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class MaterialSearchViewHelper {

    public static MaterialSearchView.OnQueryTextListener getQueryTextListener(Filterable filterableAdapter){
        return new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterableAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterableAdapter.getFilter().filter(newText);
                return false;
            }
        };
    }

}
