package com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.interfaces;

import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.responses.CategoryResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;
/**
 * Created by Admin on 20-10-2017.
 */

public interface Service {

    /**
     * Get a list of categories. List of all restaurants categorized
     * under a particular restaurant type can be obtained using /Search
     * API with Category ID as inputs
     *
     * @return the request {@link Call}
     */
    @GET("/api/v2.1/categories")
    Call<CategoryResponse> getAllCategories();
}
