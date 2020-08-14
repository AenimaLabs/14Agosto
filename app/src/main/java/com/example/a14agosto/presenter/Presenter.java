package com.example.a14agosto.presenter;

import android.util.Log;

import com.example.a14agosto.apiRetrofit.ApiRetrofit;
import com.example.a14agosto.apiRetrofit.RetrofitClient;
import com.example.a14agosto.model.BreedImageList;
import com.example.a14agosto.model.BreedList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements IPresenterBreedList {

    IViewListBreeds view;
    ApiRetrofit service = RetrofitClient.getRetrofit().create(ApiRetrofit.class);
    Call<BreedList> call = service.getBreedList();

    public Presenter(IViewListBreeds view) {
        this.view = view;
    }

    @Override
   public void loadBreedList(){
        call.enqueue(new Callback<BreedList>() {
           @Override
           public void onResponse(Call<BreedList> call, Response<BreedList> response) {
               if (response.body()!=null){
                   List<String> doggoList = response.body().getBreedlist();
                   Log.wtf("dog", String.valueOf(doggoList));
                   view.showBreedList(doggoList);

               }
           }

           @Override
           public void onFailure(Call<BreedList> call, Throwable t) {
                view.showMessageInView(t.toString());
           }
       });
   }

   public void loadImagesBreed(String dogBreed){
//       ApiRetrofit service2 = RetrofitClient.getRetrofit().create(ApiRetrofit.class);
       Call<BreedImageList> callImages = service.getBreedImageList(dogBreed);
       callImages.enqueue(new Callback<BreedImageList>() {
           @Override
           public void onResponse(Call<BreedImageList> call, Response<BreedImageList> response) {
               List<String> imageUrl = response.body().getImageUrl();
               Log.wtf("kk", String.valueOf(imageUrl));
               view.showImagesUrlList(imageUrl);
           }

           @Override
           public void onFailure(Call<BreedImageList> call, Throwable t) {
                view.showMessageInView(t.toString());
           }
       });
   }


    public interface View {
    }
}
