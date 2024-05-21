package com.example.cooper_up;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cooper_up.models.CentroModelo;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityEmpresa extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_empresa);

        TextView nombreCentro = findViewById(R.id.TVnombreEmpresa);
        TextView correoCentro = findViewById(R.id.correoCentro);
        TextView direccionCentro = findViewById(R.id.direccionCentro);
        TextView telefonoCentro = findViewById(R.id.telefonoEmpresa);
        TextView contrasenaCentro = findViewById(R.id.contraCentro);

        Button btnAdd = findViewById(R.id.btnAddAlumno);
        Button btnShow = findViewById(R.id.btnVerAlumnos);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityEmpresa.this, RegistrarAlumno.class);
                startActivity(intent);

            }
        });


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Moverse a la actividad con todos los alumnos de ese centro
            }
        });

        //Llamada para cargar todos los datos del centro que acaba de entrar

        ApiService apiService = ApiAdapter.getInstance().getApiService();
        Call<CentroModelo> call = apiService.getCentroId(1);
        call.enqueue(new Callback<CentroModelo>() {
            @Override
            public void onResponse(Call<CentroModelo> call, Response<CentroModelo> response) {
                nombreCentro.setText(response.body().getNombre().toString());
                correoCentro.setText(response.body().getEmail().toString());
                direccionCentro.setText(response.body().getDireccion().toString());
                telefonoCentro.setText(response.body().getTelefono().toString());
                contrasenaCentro.setText(response.body().getContraseña().toString());
            }

            @Override
            public void onFailure(Call<CentroModelo> call, Throwable t) {
                Toast.makeText(MainActivityEmpresa.this, "SERVER ERROR", Toast.LENGTH_SHORT).show();
            }
        });


    }

}