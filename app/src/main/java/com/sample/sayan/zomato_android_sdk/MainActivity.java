package com.sample.sayan.zomato_android_sdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.SessionConfig;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.ZomatoApi;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.interfaces.Service;
import com.sample.sayan.zomato_android_sdk.sayan_zomato_sdk.responses.CategoryResponse;

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
        mService.getAllCategories().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {

                Toast.makeText(MainActivity.this, "success: " + response.body().getCategories().get(0).getCategories().getId() +"- "+ response.body().getCategories().get(0).getCategories().getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
