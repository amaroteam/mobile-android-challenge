package com.amaro.bruno.amarochallenge;

import android.util.SparseArray;

import com.amaro.bruno.amarochallenge.catalogue.model.Product;
import com.amaro.bruno.amarochallenge.catalogue.model.Size;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockProducts {

    public static List<Product> getMockProducts(){
        Product product1 = new Product("VESTIDO TRANSPASSE BOW", "20002605", false, "R$ 199,90", Arrays.asList(
                new Size(false, "PP", "5807_343_0_PP"),
                new Size(true, "P", "5807_343_0_P"),
                new Size(true, "M", "5807_343_0_M"),
                new Size(true, "G", "5807_343_0_G"),
                new Size(false, "GG", "5807_343_0_GG")));
        Product product2 = new Product("REGATA ALCINHA FOLK", "20002570", false, "R$ 99,90", Arrays.asList(
                new Size(true, "PP", "5723_40130843_0_PP"),
                new Size(true, "P", "5723_40130843_0_P"),
                new Size(true, "M", "5723_40130843_0_M"),
                new Size(true, "G", "5723_40130843_0_G"),
                new Size(true, "GG", "5723_40130843_0_GG")));
        Product product3 = new Product("T-SHIRT LEATHER DULL", "20002602", true, "R$ 139,90", Arrays.asList(
                new Size(true, "PP", "5793_1000032_0_PP"),
                new Size(true, "P", "5793_1000032_0_P"),
                new Size(true, "M", "5793_1000032_0_M"),
                new Size(false, "G", "5793_1000032_0_G"),
                new Size(false, "GG", "5793_1000032_0_GG")));

        return Arrays.asList(product1, product2, product3);
    }

}
