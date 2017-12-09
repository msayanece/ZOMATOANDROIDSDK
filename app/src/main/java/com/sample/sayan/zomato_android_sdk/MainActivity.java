package com.sample.sayan.zomato_android_sdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.SessionConfig;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.ZomatoApi;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.interfaces.Service;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.responses.CategoryResponse;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.responses.CuisinesResponse;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.responses.DailyMenuOfRestaurantResponse;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.responses.DetailRestaurantInfoResponse;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.responses.NearByGeocodeResponse;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.responses.RestaurantCollectionsResponse;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.responses.RestaurantEstablishmentsResponse;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.responses.RestaurantReviewsResponse;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.responses.SearchCitiesResponse;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.responses.SearchResponse;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.responses.ZomatoLocationDetailsResponse;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.responses.ZomatoLocationsResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private Service mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SessionConfig sessionConfig = new SessionConfig.Builder()
                .setApiKey(getResources().getString(R.string.zomato_api_key))
                .build(getApplicationContext());
        mService = ZomatoApi.with(sessionConfig).build(getApplicationContext()).createService();

        getAllCategories();
    }

    public void getAllCategories() {
        HashMap<String, String> queryParamsMap = new HashMap<>();
        queryParamsMap.put("q", "dum");
        mService.search(queryParamsMap).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                Toast.makeText(MainActivity.this, "success: " + response.body().getRestaurants().get(0).getRestaurant().getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
