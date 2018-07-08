package com.test.amaro.amarotest.models;

import java.util.Comparator;

public class ProductComparator {

    public static class OrderingOptions {
        public static final int ALEATORY = 0;
        public static final int HIGH_ORDERING = 1;
        public static final int LOW_ORDERING = 2;
    }

    private ProductComparator() {
        // Needed empty constructor
    }

    public static class HigherPriceComparator implements Comparator<Product> {

        @Override
        public int compare(Product product, Product otherProduct) {

            double productActualPriceDouble = getProductActualPriceDouble(product.getActualPrice());
            double otherProductctualPriceDouble = getProductActualPriceDouble(
                    otherProduct.getActualPrice());

            if (productActualPriceDouble == otherProductctualPriceDouble) {
                return 0;
            }

            return Double.compare(otherProductctualPriceDouble, productActualPriceDouble);

        }
    }

    public static class LowPriceComparator implements Comparator<Product> {

        @Override
        public int compare(Product product, Product otherProduct) {

            double productActualPriceDouble = getProductActualPriceDouble(product.getActualPrice());
            double otherProductActualPriceDouble = getProductActualPriceDouble(
                    otherProduct.getActualPrice());

            if (productActualPriceDouble == otherProductActualPriceDouble) {
                return 0;
            }

            return Double.compare(productActualPriceDouble, otherProductActualPriceDouble);

        }
    }

    private static double getProductActualPriceDouble(String productAtualPrice) {
        return Double.parseDouble(
                productAtualPrice.substring(2, productAtualPrice.length())
                        .replace(',', '.'));
    }
}
