package com.simba.ShopifyRevenueCalculator.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Definition of the endpoints (and associated url parameters) associated with Shopify's Order API
 *
 * Created by t.brown on 1/18/17.
 */
public interface OrderAPI {

    public static int NUM_RESULTS = 50; // **** Max: 250 ****

    @GET("/admin/orders.json")
    Call<Responses.MyOrders> getAllOrders(
            @Query("page") int pageNo,
            @Query("limit") int maxNoResults,
            @Query("access_token") String accessToken);
}
