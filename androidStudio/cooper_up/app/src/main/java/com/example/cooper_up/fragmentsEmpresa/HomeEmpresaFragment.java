package com.example.cooper_up.fragmentsEmpresa;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cooper_up.R;
import com.example.cooper_up.adapters.RValumnos;
import com.example.cooper_up.adapters.RVpracticas;
import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.models.EmpresaModelo;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeEmpresaFragment extends Fragment {
    private EmpresaModelo empresa;

    private RecyclerView recyclerView;

    private ArrayList<AlumnoModel> itemList = new ArrayList<>();

    private RValumnos adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_empresa, container, false);


        // Recuperar el objeto EmpresaModelo del argumento
        if (getArguments() != null) {
            empresa = (EmpresaModelo) getArguments().getSerializable("empresa");
        }

        recyclerView = view.findViewById(R.id.recyclerViewalumnosHomeEmpresa);
        itemList = new ArrayList<>();
        adapter = new RValumnos(getContext(), itemList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ApiAdapter apiAdapter = ApiAdapter.getInstance();
        ApiService apiService = apiAdapter.getApiService();

        Call<List<AlumnoModel>> call = apiService.getAllAlumnos();

        call.enqueue(new Callback<List<AlumnoModel>>() {
            @Override
            public void onResponse(Call<List<AlumnoModel>> call, Response<List<AlumnoModel>> response) {

                if(response.isSuccessful()){
                    List<AlumnoModel> allAlumnos = response.body();

                    adapter.actualizarLista(allAlumnos);
                }
            }

            @Override
            public void onFailure(Call<List<AlumnoModel>> call, Throwable t) {
                Log.e("Error", "Error al obtener los alumnos: " + t.getMessage());
            }
        });

        // Usa el objeto empresa según sea necesario

        return view;
    }
}

