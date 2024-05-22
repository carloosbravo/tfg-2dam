package com.example.cooper_up.fragmentsEmpresa;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cooper_up.EditarUsuario;
import com.example.cooper_up.R;
import com.example.cooper_up.models.EmpresaModelo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileEmpresaFragment extends Fragment {

    private EmpresaModelo empresa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_empresa, container, false);

        FloatingActionButton editarPerfilButton = view.findViewById(R.id.editarPerfilEmpresaButton);

        // Recuperar el objeto EmpresaModelo del argumento
        if (getArguments() != null) {
            empresa = (EmpresaModelo) getArguments().getSerializable("empresa");
        }

        // Configurar el click listener del botón para abrir EditarUsuario con el objeto AlumnoModel


        // Usa el objeto empresa según sea necesario

        if(empresa != null){
            TextView nombreEmpresa = view.findViewById(R.id.nombreEmpresaPerfilTV);
            TextView telefonoEmpresa = view.findViewById(R.id.telefonoEmpresaPerfilTV);
            TextView emailEmpresa = view.findViewById(R.id.emailEmpresaPerfilTV);
            TextView direccionEmpresa = view.findViewById(R.id.direccionEmpresaTV);
            TextView biografiaEmpresa = view.findViewById(R.id.biografiEmpresaTV);

            nombreEmpresa.setText(empresa.getNombre());
            telefonoEmpresa.setText(empresa.getTelefono());
            emailEmpresa.setText(empresa.getEmail());
            direccionEmpresa.setText(empresa.getDireccion());
            biografiaEmpresa.setText(empresa.getBiografia());

        }

        return view;

    }
}