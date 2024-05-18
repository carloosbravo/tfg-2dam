package com.example.cooper_up.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.cooper_up.EditarUsuario;
import com.example.cooper_up.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        FloatingActionButton editarPerfilButton = view.findViewById(R.id.editarPerfilButton);
        //cuando se haga click en el boton se cambia a ala actividad de editar usuario

        editarPerfilButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), EditarUsuario.class);
            startActivity(intent);
        });

        return view;
    }
}
