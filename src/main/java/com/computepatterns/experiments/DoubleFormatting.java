package com.computepatterns.experiments;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by sivt on 08/06/15.
 */
public class DoubleFormatting {
    public static final void main(String[] args){
        Double testValue = 123453243242467891212121313123212.22598689979;
        System.out.println(testValue.toString());

        BigDecimal decimalValue = BigDecimal.valueOf(23453243242467891212121313123212.22598689979);

    }
}
