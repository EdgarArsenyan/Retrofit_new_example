package com.noringerazancutyun.retrofit_new_example.APImanager;

import com.noringerazancutyun.retrofit_new_example.Model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.noringerazancutyun.retrofit_new_example.Util.ApiUrl.END_POINT_1;
import static com.noringerazancutyun.retrofit_new_example.Util.ApiUrl.END_POINT_2;


public interface RetrofitService {

    @GET(END_POINT_2)
    Call<List<Model>> getComments(@Path("id") int postId);

    @GET(END_POINT_1)
    Call<List<Model>> getUser(@Query("userId") int userId);


}
