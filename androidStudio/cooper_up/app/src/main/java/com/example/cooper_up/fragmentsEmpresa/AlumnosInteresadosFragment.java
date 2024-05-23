package com.example.cooper_up.fragmentsEmpresa;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cooper_up.Curriculum;
import com.example.cooper_up.EliminarPractica;
import com.example.cooper_up.R;
import com.example.cooper_up.adapters.RValumnos;
import com.example.cooper_up.adapters.RVpracticasEmpresa;
import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.models.EmpresaModelo;
import com.example.cooper_up.models.PracticaModel;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlumnosInteresadosFragment extends Fragment {

    private EmpresaModelo empresa;
    private RecyclerView recyclerView;
    private ArrayList<PracticaModel> itemList = new ArrayList<>();
    private RVpracticasEmpresa adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alumnos_interesados, container, false);

        // Recuperar el objeto EmpresaModelo del argumento

        if (getArguments() != null) {
            empresa = (EmpresaModelo) getArguments().getSerializable("empresa");
        }

        if (empresa == null) {
            // Manejar el caso en que empresa es nulo
            Log.e("Error", "El objeto empresa es nulo");
            return view;
        }


        recyclerView = view.findViewById(R.id.recyclerViewEmpresaPracticas);
        itemList = new ArrayList<>();
        adapter = new RVpracticasEmpresa(getContext(), itemList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ApiAdapter apiAdapter = ApiAdapter.getInstance();
        ApiService apiService = apiAdapter.getApiService();

        Call<List<PracticaModel>> call = apiService.getPracticasByIdEmpresa(empresa.getId());

        call.enqueue(new Callback<List<PracticaModel>>() {
            @Override
            public void onResponse(Call<List<PracticaModel>> call, Response<List<PracticaModel>> response) {
                if(response.isSuccessful()){
                    List<PracticaModel> practicasEmpresa = response.body();

                    adapter.actualizarLista(practicasEmpresa);
                }
            }

            @Override
            public void onFailure(Call<List<PracticaModel>> call, Throwable t) {
                Log.e("Error", "Error al obtener las practicas: " + t.getMessage());

            }
        });


        // Configurar el TextView y el click listener
        TextView eliminarPracticaTV = view.findViewById(R.id.eliminarPracticaTV);
        eliminarPracticaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad EliminarPractica
                Intent intent = new Intent(getContext(), EliminarPractica.class);
                // Pasar el objeto empresa
                intent.putExtra("empresa", empresa);
                startActivity(intent);
            }
        });
        return view;
    }
}
