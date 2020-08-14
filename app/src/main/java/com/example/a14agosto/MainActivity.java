package com.example.a14agosto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.a14agosto.apiRetrofit.ApiRetrofit;
import com.example.a14agosto.apiRetrofit.RetrofitClient;
import com.example.a14agosto.model.BreedImageList;
import com.example.a14agosto.model.BreedList;
import com.example.a14agosto.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Presenter.View {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialFragmentBreed();}



        private void initialFragmentBreed() {
            FragmentBreedList breedListFragment = FragmentBreedList.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frameLayout1, breedListFragment, breedListFragment.getClass().getSimpleName())
                    .commit();
}}
