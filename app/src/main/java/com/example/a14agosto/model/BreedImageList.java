package com.example.a14agosto.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BreedImageList {

    @SerializedName("message")
    private ArrayList<String> imageUrl;
    private String status;

    public ArrayList<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(ArrayList<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStatus() { return status;    }

    public void setStatus(String status) {this.status = status;    }
}
