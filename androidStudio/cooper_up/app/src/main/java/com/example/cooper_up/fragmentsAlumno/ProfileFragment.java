package com.example.cooper_up.fragmentsAlumno;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cooper_up.EditarUsuario;
import com.example.cooper_up.R;
import com.example.cooper_up.models.AlumnoModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;

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

        FloatingActionButton editarPerfilButton = view.findViewById(R.id.editarPerfilButton);

        // Configurar el click listener del botón para abrir EditarUsuario con el objeto AlumnoModel
        editarPerfilButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), EditarUsuario.class);
            intent.putExtra("alumno", alumno);
            startActivity(intent);
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
            valoraciones.setText(alumno.getValoracion_profesorado());

        }


        return view;
    }
}
