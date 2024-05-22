package com.example.cooper_up.fragmentsEmpresa;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cooper_up.R;
import com.example.cooper_up.adapters.RValumnos;
import com.example.cooper_up.models.EmpresaModelo;

public class HomeEmpresaFragment extends Fragment {
    private EmpresaModelo empresa;

    private RecyclerView recyclerView;

    private RValumnos adapter;
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_empresa, container, false);

        // Recuperar el objeto EmpresaModelo del argumento
        if (getArguments() != null) {
            empresa = (EmpresaModelo) getArguments().getSerializable("empresa");
        }

        // Usa el objeto empresa según sea necesario

        return view;
    }
}

