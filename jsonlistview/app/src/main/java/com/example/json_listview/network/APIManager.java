package com.example.json_listview.network;

import android.telecom.Call;

import com.example.json_listview.model.Newsmodel;
import com.example.json_listview.model.PostModel;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIManager {
    String SERVER_URL = "https://tommyprivateguide.com";

    @GET("/dat.json")
    Call<Newsmodel> getNews();

    @GET("/wp-json/wp/v2/posts")
    Call<List<PostModel>> getListNews(@Query("page") String page, @Query("per_page") String per_p);
}
