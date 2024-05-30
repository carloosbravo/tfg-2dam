package com.example.cooper_up.fragmentsAlumno;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cooper_up.Curriculum;
import com.example.cooper_up.EditarUsuario;
import com.example.cooper_up.R;
import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.models.CentroModelo;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {

    private AlumnoModel alumno;



    public ProfileFragment() {
        // Required empty public constructor
    }

    // Método para recibir el objeto AlumnoModel
    public static ProfileFragment newInstance(AlumnoModel alumno) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putSerializable("alumno", alumno);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            alumno = (AlumnoModel) getArguments().getSerializable("alumno");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView cv = view.findViewById(R.id.cvTV);

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Curriculum.class);
                intent.putExtra("alumno", alumno);
                startActivity(intent);
            }
        });

        FloatingActionButton editarPerfilButton = view.findViewById(R.id.editarPerfilButton);

        // Configurar el click listener del botón para abrir EditarUsuario con el objeto AlumnoModel
        editarPerfilButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), EditarUsuario.class);
            intent.putExtra("alumno", alumno);
            startActivity(intent);
        });

        ApiAdapter apiAdapter = ApiAdapter.getInstance();
        ApiService apiService = apiAdapter.getApiService();

        TextView nombreCentro = view.findViewById(R.id.centroAlumnoTV);

        SharedPreferences sharedPref = requireActivity().getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        int idAlumno = sharedPref.getInt("idAlumno", 1);

        Call<AlumnoModel> callalumno = apiService.getAlumnos(idAlumno);
        callalumno.enqueue(new Callback<AlumnoModel>() {
            @Override
            public void onResponse(Call<AlumnoModel> call, Response<AlumnoModel> response) {
                alumno = response.body();

                Call<CentroModelo> callcentro = apiService.getCentroId(alumno.getCentro_id());

                callcentro.enqueue(new Callback<CentroModelo>() {
                    @Override
                    public void onResponse(Call<CentroModelo> call, Response<CentroModelo> response) {
                        if (response.isSuccessful()){
                            CentroModelo centro = response.body();
                            nombreCentro.setText(centro.getNombre());
                        }

                    }

                    @Override
                    public void onFailure(Call<CentroModelo> call, Throwable t) {
                        Toast.makeText(getActivity(), "error nombre empresa", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<AlumnoModel> call, Throwable t) {

            }
        });



        if(alumno != null){
            TextView nombreAlumno = view.findViewById(R.id.nombreALumnoTV);
            TextView correo = view.findViewById(R.id.emailTV);
            TextView nombreAlumnoTitulo = view.findViewById(R.id.nombreALumnoTituloTV);
            TextView valoraciones = view.findViewById(R.id.valoracionesProfileTV);
            TextView telefono = view.findViewById(R.id.telefonoTV);


            nombreAlumno.setText(alumno.getNombre());
            nombreAlumnoTitulo.setText(alumno.getNombre());
            telefono.setText(alumno.getTelefono());
            correo.setText(alumno.getEmail());
            valoraciones.setText(alumno.getGrado());

        }





        return view;
    }
}
