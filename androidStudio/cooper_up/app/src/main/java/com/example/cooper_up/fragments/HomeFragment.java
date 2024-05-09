package com.example.cooper_up.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cooper_up.R;

public class HomeFragment extends Fragment {

   public HomeFragment(){

   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Verifica si la lista de explotaciones está vacía antes de configurar el adaptador

        return rootView;
    }

}