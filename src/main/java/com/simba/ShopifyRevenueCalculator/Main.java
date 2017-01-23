package com.simba.ShopifyRevenueCalculator;

import java.math.BigDecimal;

/**
 * Run THIS!!
 *
 * Created by t.brown on 1/22/17.
 */
public class Main {

    public static void main(String[] args) {
        BigDecimal totalOrderRevenue  = OrderRevenueCalculator.calculate();
        System.out.println("The total revenue for your orders is " + totalOrderRevenue);
    }
}
