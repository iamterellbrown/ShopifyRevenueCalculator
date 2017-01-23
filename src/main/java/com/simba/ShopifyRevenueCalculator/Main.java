package com.simba.ShopifyRevenueCalculator;

import java.math.BigDecimal;

/**
 * Run this to calculate the revenue for all orders from your store.
 *
 * Assumption: Revenue consists of the price of all the items in an order,
 *       taxes included, and discounts subtracted.
 *
 * Created by t.brown on 1/22/17.
 */
public class Main {

    public static void main(String[] args) {
        BigDecimal totalOrderRevenue  = OrderRevenueCalculator.calculate();
        System.out.println("The total revenue for your orders is " + totalOrderRevenue);
    }
}
