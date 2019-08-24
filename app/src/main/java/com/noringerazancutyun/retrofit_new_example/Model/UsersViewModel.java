package com.noringerazancutyun.retrofit_new_example.Model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.noringerazancutyun.retrofit_new_example.APImanager.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.noringerazancutyun.retrofit_new_example.Util.ApiUrl.BASE_URL;

public class UsersViewModel extends ViewModel {

    private MutableLiveData<List<Model>> userList;

    public LiveData<List<Model>> getData() {
        if (userList == null) {
            userList = new MutableLiveData<List<Model>>();
            loadUsers();
        }

        return userList;
    }

    private void loadUsers() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<List<Model>> call1 = retrofitService.getUser(2);
        Call<List<Model>> call2 = retrofitService.getComments(1);
        call1.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                userList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });

        call2.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                userList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }
}
