package com.example.cooper_up.fragmentsAlumno;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        if (getArguments() != null) {
            alumno = (AlumnoModel) getArguments().getSerializable("alumno");
        }
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

        Call<CentroModelo> call = apiService.getCentroId(alumno.getCentro_id());

        call.enqueue(new Callback<CentroModelo>() {
            @Override
            public void onResponse(Call<CentroModelo> call, Response<CentroModelo> response) {
                if (response.isSuccessful()){
                    nombreCentro.setText(response.body().getNombre());
                }

            }

            @Override
            public void onFailure(Call<CentroModelo> call, Throwable t) {

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
