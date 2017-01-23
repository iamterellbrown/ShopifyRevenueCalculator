package com.simba.ShopifyRevenueCalculator.api;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by t.brown on 1/18/17.
 */
public class ShopifyClient {

    static String API_HOST = "https://shopicruit.myshopify.com";

    // Shopify APIs
    private static OrderAPI orderAPI;


    /**
     * Generatates (if non-existent) and returns a gateway to Shopify's Order API
     * @return
     */
    private static OrderAPI getOrderAPI() {

        if (orderAPI == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            orderAPI = retrofit.create(OrderAPI.class);
        }

        return orderAPI;
    }


    /**
     * Returns a list of orders on the page number provided
     * @param currentPageNo
     * @return
     */
    public static ArrayList<Responses.Order> getOrdersByPageNumber(int currentPageNo) {

        Call<Responses.MyOrders> apiRequest = ShopifyClient.getOrderAPI().getAllOrders(
                currentPageNo,
                OrderAPI.NUM_RESULTS,
                "c32313df0d0ef512ca64d5b336a0d7c6");

        try {
            return apiRequest.execute().body().getListOfOrders();
        } catch (IOException e) {
            return null;
        }
    }
}
