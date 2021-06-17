package com.example.testreddit.engine.manager;

import android.util.Log;


import com.example.testreddit.common.BaseConstants;
import com.example.testreddit.engine.network.RetrofitClient;
import com.example.testreddit.engine.service.ApiService;
import com.example.testreddit.engine.service.ResponseCallback;
import com.example.testreddit.model.Reply;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DataManager {

    private ResponseCallback responseCallback;


    public static DataManager newInstance(ResponseCallback callback) {
        return new DataManager(callback);
    }


    private DataManager(ResponseCallback responseCallback) {
        this.responseCallback = responseCallback;
    }


    public void getResponse() {

        ApiService apiService = RetrofitClient.newInstance().create(ApiService.class);
        Call<Reply> call = apiService.getResponseAsJson();
        call.enqueue(new Callback<Reply>() {
            @Override
            public void onResponse(Call<Reply> call, Response<Reply> response) {

                if (response.body() != null) {
                    responseCallback.onResponse(response.body().getData().getChildren());
                }
            }

            @Override
            public void onFailure(Call<Reply> call, Throwable t) {
                Log.e(BaseConstants.TAG, t.toString());
            }
        });
    }
}