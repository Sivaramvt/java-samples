package com.computepatterns.experiments;

import java.math.BigDecimal;

public class BigDecimalFormatter {
    public static void main(String[] args) {
        double testValue = 12.348;
        BigDecimal bigDecimal = BigDecimal.valueOf(testValue);
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(bigDecimal.toString());

    }
}
