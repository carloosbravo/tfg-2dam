package com.example.cooper_up.fragmentsEmpresa;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cooper_up.R;
import com.example.cooper_up.models.EmpresaModelo;

public class AlumnosInteresadosFragment extends Fragment {

    private EmpresaModelo empresa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alumnos_interesados, container, false);

        // Recuperar el objeto EmpresaModelo del argumento
        if (getArguments() != null) {
            empresa = (EmpresaModelo) getArguments().getSerializable("empresa");
        }

        // Usa el objeto empresa según sea necesario

        return view;
    }
}
