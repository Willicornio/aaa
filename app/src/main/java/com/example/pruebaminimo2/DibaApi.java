package com.example.pruebaminimo2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

interface DibaApi {


    @GET("\"pag-ini/{numinici}/pag-fi/{numfinal}\"")
    Call<Cities> getData(@Path("numinici") int pagini, @Path("numfinal") int pagfi);


    /*@GET("tracks/{owner}/{repo}/contributors")
    Call<ArrayList<Contributor>> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);
*/

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://do.diba.cat/api/dataset/municipis/format/json/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}