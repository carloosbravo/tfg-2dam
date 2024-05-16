package com.example.cooper_up.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cooper_up.R;
import com.example.cooper_up.adapters.RVpracticas;
import com.example.cooper_up.models.PracticaModel;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {


    private RecyclerView recyclerView;
    private ArrayList<PracticaModel> itemList = new ArrayList<>();

    private List<PracticaModel> allPracticas;

    private RVpracticas adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();

        adapter = new RVpracticas(getContext(), itemList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ApiAdapter apiAdapter = ApiAdapter.getInstance();

        // Obtener el servicio ApiInterface
        ApiService apiService = apiAdapter.getApiService();

        Call<List<PracticaModel>> call = apiService.getAllPracticas();

        call.enqueue(new Callback<List<PracticaModel>>() {
            @Override
            public void onResponse(Call<List<PracticaModel>> call, Response<List<PracticaModel>> response) {

                if(response.isSuccessful()){
                    allPracticas = response.body();

                    Log.d("Practicas", "Lista de Practicas: " + allPracticas.toString());

                    adapter.actualizarLista(allPracticas);
                }
            }

            @Override
            public void onFailure(Call<List<PracticaModel>> call, Throwable t) {

            }
        });

        ArrayList<PracticaModel> listaArmarios = new ArrayList<>();

        return rootView;
    }

}