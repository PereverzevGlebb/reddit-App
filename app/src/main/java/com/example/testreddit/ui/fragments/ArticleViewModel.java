package com.example.testreddit.ui.fragments;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testreddit.common.BaseConstants;
import com.example.testreddit.engine.manager.DataManager;
import com.example.testreddit.engine.service.ResponseCallback;
import com.example.testreddit.model.Children;

import java.util.List;



public class ArticleViewModel extends ViewModel implements ResponseCallback {

    private MutableLiveData<List<Children>> data;

    public LiveData<List<Children>> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
            DataManager.newInstance(this).getResponse();
            Log.e(BaseConstants.TAG, "1");
        }
        Log.e(BaseConstants.TAG, "2");
        return data;
    }

    @Override
    public void onResponse(List<Children> childrenList) {
        data.setValue(childrenList);
    }

}