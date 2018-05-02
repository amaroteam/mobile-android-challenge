package com.amaro.bruno.amarochallenge;

import com.amaro.bruno.amarochallenge.catalogue.products.model.Product;
import com.amaro.bruno.amarochallenge.catalogue.products.model.Size;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MockProducts {

    public static List<Product> getMockProducts(){
        Product product1 = new Product("VESTIDO TRANSPASSE BOW", "20002605", false, "R$ 199,90",
                "R$ 199,90", "", "3x R$ 66,63",
                "https://d3l7rqep7l31az.cloudfront.net/images/products/20002605_615_catalog_1.jpg?1460136912",
                Arrays.asList(
                        new Size(false, "PP", "5807_343_0_PP"),
                        new Size(true, "P", "5807_343_0_P"),
                        new Size(true, "M", "5807_343_0_M"),
                        new Size(true, "G", "5807_343_0_G"),
                        new Size(false, "GG", "5807_343_0_GG")));
        Product product2 = new Product("REGATA ALCINHA FOLK", "20002570", false, "R$ 99,90",
                "R$ 99,90", "", "3x R$ 33,30",
                "https://d3l7rqep7l31az.cloudfront.net/images/products/20002570_002_catalog_1.jpg?1459948578",
                Arrays.asList(
                        new Size(true, "PP", "5723_40130843_0_PP"),
                        new Size(true, "P", "5723_40130843_0_P"),
                        new Size(true, "M", "5723_40130843_0_M"),
                        new Size(true, "G", "5723_40130843_0_G"),
                        new Size(true, "GG", "5723_40130843_0_GG")));
        Product product3 = new Product("T-SHIRT LEATHER DULL", "20002602", true, "R$ 139,90",
                "R$ 119,90", "12%", "3x R$ 39,97",
                "https://d3l7rqep7l31az.cloudfront.net/images/products/20002575_027_catalog_1.jpg?1459537946",
                Arrays.asList(
                        new Size(true, "PP", "5793_1000032_0_PP"),
                        new Size(true, "P", "5793_1000032_0_P"),
                        new Size(true, "M", "5793_1000032_0_M"),
                        new Size(false, "G", "5793_1000032_0_G"),
                        new Size(false, "GG", "5793_1000032_0_GG")));
        Product product4 = new Product("BATA DECOTE FLUID", "20002581", true, "R$ 149,90",
                "R$ 149,90", "", "3x R$ 49,97",
                "https://d3l7rqep7l31az.cloudfront.net/images/products/20002581_614_catalog_1.jpg?1459536611",
                Arrays.asList(
                        new Size(false, "PP", "5749_341_0_PP"),
                        new Size(true, "P", "5749_341_0_P"),
                        new Size(false, "M", "5749_341_0_M"),
                        new Size(true, "G", "5749_341_0_G"),
                        new Size(true, "GG", "5749_341_0_GG")));
        Product product5 = new Product("T-SHIRT LEATHER DULL", "20002602", true, "R$ 139,90",
                "R$ 119,90", "12%", "3x R$ 39,97",
                "",
                Arrays.asList(
                        new Size(true, "PP", "5793_1000032_0_PP"),
                        new Size(true, "P", "5793_1000032_0_P"),
                        new Size(true, "M", "5793_1000032_0_M"),
                        new Size(false, "G", "5793_1000032_0_G"),
                        new Size(false, "GG", "5793_1000032_0_GG")));
        Product product6 = new Product("CAMISA SUEDE SPAN", "20002602", true, "R$ 139,90",
                "R$ 189,90", "", "3x R$ 63,30",
                "https://d3l7rqep7l31az.cloudfront.net/images/products/20002584_035_catalog_1.jpg?1459947139",
                Arrays.asList(
                        new Size(true, "PP", "5793_1000032_0_PP"),
                        new Size(true, "P", "5793_1000032_0_P"),
                        new Size(true, "M", "5793_1000032_0_M"),
                        new Size(false, "G", "5793_1000032_0_G"),
                        new Size(false, "GG", "5793_1000032_0_GG")));
        Product product7 = new Product("CALÇA CLASSIC PRINT", "20002634", true, "R$ 159,90",
                "R$ 159,90", "", "3x R$ 53,30",
                "https://d3l7rqep7l31az.cloudfront.net/images/products/20002634_613_catalog_1.jpg?1459548109",
                Arrays.asList(
                        new Size(true, "36", "5865_339_0_36"),
                        new Size(true, "38", "5865_339_0_38"),
                        new Size(true, "40", "5865_339_0_40"),
                        new Size(false, "42", "5865_339_0_42"),
                        new Size(false, "44", "5865_339_0_44")));
        Product product8 = new Product("BOLSA FLAP TRIANGLE", "20002945", true, "R$ 199,90",
                "R$ 159,90", "25%", "3x R$ 53,30",
                "https://d3l7rqep7l31az.cloudfront.net/images/products/20002945_027_catalog_1.jpg?1459540966",
                Collections.singletonList(
                        new Size(true, "U", "6559_1000054_0_U")));

        return Arrays.asList(product1, product2, product3, product4, product5, product6, product7, product8);
    }

}
