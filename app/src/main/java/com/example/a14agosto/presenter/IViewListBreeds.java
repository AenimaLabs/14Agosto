package com.example.a14agosto.presenter;

import java.util.List;

public interface IViewListBreeds {

    void showBreedList(List<String > dogBreedList);

    void showImagesUrlList(List<String> dogsUrlList);

    void showMessageInView(String message);
}
