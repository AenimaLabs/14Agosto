package com.example.a14agosto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.PrecomputedText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a14agosto.adapter.DogAdapter;
import com.example.a14agosto.presenter.IViewListBreeds;
import com.example.a14agosto.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentBreedList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBreedList extends Fragment implements DogAdapter.ItemClick, IViewListBreeds {

    private Presenter presenter;
    private DogAdapter adapter;
    private RecyclerView recyclerView;
    private List<String> doggys = new ArrayList<>();

    public FragmentBreedList() {
        // Required empty public constructor
    }

    public static FragmentBreedList newInstance() {
        FragmentBreedList fragment = new FragmentBreedList();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new Presenter(this);
        presenter.loadBreedList();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_breed_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }

    @Override
    public void onClick(String dog) {
        Toast.makeText(getContext(), dog, Toast.LENGTH_SHORT).show();
        presenter.loadImagesBreed(dog);
    }

    @Override
    public void showBreedList(List<String> dogBreedList) {
        adapter = new DogAdapter(dogBreedList, getContext(),this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showImagesUrlList(List<String> dogsUrlList) {
        Log.e("URL", dogsUrlList.toString());
        initializeFragmentBreed(dogsUrlList);
    }

    @Override
    public void showMessageInView(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }



    private void initializeFragmentBreed(List<String> urls) {
        FragmentBreedImageList breedImageListFragment = FragmentBreedImageList.newInstance(urls);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout1, breedImageListFragment, breedImageListFragment.getClass().getSimpleName())
                .addToBackStack("Algo")
                .commit();
    }





}