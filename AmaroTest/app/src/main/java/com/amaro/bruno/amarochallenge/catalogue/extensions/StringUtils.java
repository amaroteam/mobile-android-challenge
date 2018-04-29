package com.amaro.bruno.amarochallenge.catalogue.extensions;

import java.text.NumberFormat;

public class StringUtils {

    public static Double convertCurrencyToDouble(String currency){
        String validChars = "123456789,.";

        if(currency != null && currency.length() > 0){
            for(char chStr : currency.toCharArray()){
                if(!validChars.contains(Character.toString(chStr))){
                    currency = currency.replace(Character.toString(chStr), "").replace(",", ".");
                }
            }

            return Double.parseDouble(currency);
        }

        return null;
    }

}
