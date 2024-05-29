package com.example.cooper_up.fragmentsAlumno;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class PracticasSolicitadasFragment extends Fragment {

    private RecyclerView recyclerView;
    private RVpracticas adapter;
    private ArrayList<PracticaModel> itemList = new ArrayList<>();
    private AlumnoModel alumno;
    public PracticasSolicitadasFragment(){

    }

    public static PracticasSolicitadasFragment newInstance(AlumnoModel alumno) {
        PracticasSolicitadasFragment fragment = new PracticasSolicitadasFragment();
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

        View rootView = inflater.inflate(R.layout.fragment_practicas_alumno, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerViewPracticasSolicitadas);
        itemList = new ArrayList<>();
        adapter = new RVpracticas(getContext(), itemList,alumno);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        SharedPreferences sharedPref = requireActivity().getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        int idAlumno = sharedPref.getInt("idAlumno", 1);

        //declaracion del retrofit para realizar la llamada
        ApiAdapter apiAdapter = ApiAdapter.getInstance();
        ApiService apiService = apiAdapter.getApiService();

        Call<List<PracticaModel>> call = apiService.getPracticasByIdAlumno(idAlumno);

        call.enqueue(new Callback<List<PracticaModel>>() {
            @Override
            public void onResponse(Call<List<PracticaModel>> call, Response<List<PracticaModel>> response) {

                if(response.isSuccessful()){
                    List<PracticaModel> practicasSolicitadas = response.body();
                    Log.d("Practicas", "Lista de Practicas: " + practicasSolicitadas.toString());
                    adapter.actualizarLista(practicasSolicitadas);
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