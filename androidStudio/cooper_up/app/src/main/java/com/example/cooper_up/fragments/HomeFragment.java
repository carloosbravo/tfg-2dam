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
import com.example.cooper_up.models.AlumnoModel;
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
    private RVpracticas adapter;
    private AlumnoModel alumno;

    public HomeFragment() {
        // Required empty public constructor
    }

    // Método para recibir el objeto AlumnoModel
    public static HomeFragment newInstance(AlumnoModel alumno) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putSerializable("alumno", alumno);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            alumno = (AlumnoModel) getArguments().getSerializable("alumno");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();
        adapter = new RVpracticas(getContext(), itemList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ApiAdapter apiAdapter = ApiAdapter.getInstance();
        ApiService apiService = apiAdapter.getApiService();

        Call<List<PracticaModel>> call = apiService.getAllPracticas();

        call.enqueue(new Callback<List<PracticaModel>>() {
            @Override
            public void onResponse(Call<List<PracticaModel>> call, Response<List<PracticaModel>> response) {
                if (response.isSuccessful()) {
                    List<PracticaModel> allPracticas = response.body();
                    Log.d("Practicas", "Lista de Practicas: " + allPracticas.toString());
                    adapter.actualizarLista(allPracticas);
                }
            }

            @Override
            public void onFailure(Call<List<PracticaModel>> call, Throwable t) {
                Log.e("Error", "Error al obtener las prácticas: " + t.getMessage());
            }
        });

        return rootView;
    }
}
