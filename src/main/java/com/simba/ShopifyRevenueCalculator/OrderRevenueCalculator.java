package com.simba.ShopifyRevenueCalculator;

import com.simba.ShopifyRevenueCalculator.api.Responses.*;
import com.simba.ShopifyRevenueCalculator.api.ShopifyClient;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by t.brown on 1/18/17.
 */
public class OrderRevenueCalculator {


    public static BigDecimal calculate() {
        int currentPageNo = 1;
        BigDecimal revenueOnCurrentPage = new BigDecimal(0);
        BigDecimal totalRevenue = new BigDecimal(0);

        ArrayList<Order> orderList;

        while (true) {
           System.out.println("Calculating revenue for orders on page " + currentPageNo +" ...");

            orderList = ShopifyClient.getOrdersByPageNumber(currentPageNo);

            if (orderList == null || orderList.isEmpty()) {
              break;
            }

            revenueOnCurrentPage = calculateRevenueFromOrderList(orderList, currentPageNo);
            totalRevenue = totalRevenue.add(revenueOnCurrentPage);
            currentPageNo += 1;
       }

        System.out.println("There are no more orders.");
        System.out.println();
        System.out.println();
        return totalRevenue;
    }

    private static BigDecimal calculateRevenueFromOrderList(ArrayList<Order> listOfOrders, int pageNo) {
        BigDecimal revenue = new BigDecimal(0);

        for (Order order : listOfOrders) {
            revenue = revenue.add(order.getOrderPrice());
        }

        System.out.println("The revenue for page " + pageNo + " of your orders is " + revenue);
        return revenue;
    }
}
