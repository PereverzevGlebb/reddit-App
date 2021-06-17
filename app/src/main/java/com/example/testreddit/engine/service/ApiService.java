package com.example.testreddit.engine.service;


import com.example.testreddit.common.BaseConstants;
import com.example.testreddit.model.Reply;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET(BaseConstants.KEY)
    Call<Reply> getResponseAsJson();
}
