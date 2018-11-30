package com.lingtao.myretrofit;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface MyRetrofit2Service {


    @GET("content/{url}")
    Call<ResponseBody> getData(@Path(value = "url",encoded = true) String url, @QueryMap Map<String, Object> map);

    @GET
    Call<String> get(@Url String url, @QueryMap Map<String,Object> params);

    @GET("list.from")
    Call<ResponseBody> getDataByGETURL(@QueryMap Map<String, String> map);

    @POST("list.from")
    @FormUrlEncoded
    Call<ResponseBody> getDataByPost(@FieldMap Map<String, String> map);
}
