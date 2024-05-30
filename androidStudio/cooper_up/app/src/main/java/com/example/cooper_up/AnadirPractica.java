package com.example.cooper_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.cooper_up.mains.MainActivityCentro;
import com.example.cooper_up.mains.MainActivityEmpresa;
import com.example.cooper_up.models.CentroModelo;
import com.example.cooper_up.models.EmpresaModelo;
import com.example.cooper_up.models.PracticaModel;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnadirPractica extends AppCompatActivity {

    TextInputEditText titulo;

    TextInputEditText descripcion;

    Button btnPublicar;

    EmpresaModelo empresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_practica);

        empresa = (EmpresaModelo) getIntent().getSerializableExtra("empresa");
        titulo = findViewById(R.id.tituloPractica);
        descripcion = findViewById(R.id.descripcionPractica);
        btnPublicar = findViewById(R.id.btnpublicarPractica);
        ImageButton btnVolver = findViewById(R.id.volverPerfilButton);

        SharedPreferences sharedPref = this.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        int idEmpresa = sharedPref.getInt("idEmpresa", 1);

        btnPublicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ApiAdapter apiAdapter = ApiAdapter.getInstance();
                ApiService apiService = apiAdapter.getApiService();

                PracticaModel practica = new PracticaModel();
                practica.setTitulo_practica(titulo.getText().toString());
                practica.setDescripcion(descripcion.getText().toString());
                practica.setId_empresa(idEmpresa);

                Call<PracticaModel> call = apiService.publicar(practica);

                call.enqueue(new Callback<PracticaModel>() {
                    @Override
                    public void onResponse(Call<PracticaModel> call, Response<PracticaModel> response) {
                        Toast.makeText(AnadirPractica.this, "Práctica publicada con éxito", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AnadirPractica.this, MainActivityCentro.class);
                        intent.putExtra("empresa",empresa);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<PracticaModel> call, Throwable t) {
                        Toast.makeText(AnadirPractica.this, "Error al publicar", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnadirPractica.this, MainActivityEmpresa.class);
                intent.putExtra("empresa",empresa);
                startActivity(intent);
            }
        });
    }
}