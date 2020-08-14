package com.example.a14agosto.apiRetrofit;

import com.example.a14agosto.model.BreedImageList;
import com.example.a14agosto.model.BreedList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRetrofit {

   @GET("api/breeds/list/")
    Call<BreedList> getBreedList();

   @GET ("api/breed/{breed}/images/")
    Call<BreedImageList> getBreedImageList(String doggybreeds);

}
