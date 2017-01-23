package com.simba.ShopifyRevenueCalculator.api;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * Definition of the JSON responses that the Shopify API returns.
 * These classes are used by retrofit to map the JSON responses to Java Objects
 *
 * Note: Definitions may not contain all fields associated with the JSON response.
 * Only those that are of use whithin this context.
 *
 * Created by t.brown on 1/18/17.
 */
public class Responses {

    public class MyOrders {

        @SerializedName("orders")
        private ArrayList<Order> listOfOrders;


        public ArrayList<Order> getListOfOrders() {
            return listOfOrders;
        }
    }

    public class Order {

        @SerializedName("total_price")
        private String orderPriceStr;
        private BigDecimal orderPrice;


        public BigDecimal getOrderPrice() {
            if (orderPrice == null) {
                orderPrice = new BigDecimal(orderPriceStr);
            }
            return orderPrice;
        }
    }
}
