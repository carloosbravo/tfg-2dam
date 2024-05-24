package com.example.cooper_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.cooper_up.mains.MainActivityCentro;
import com.example.cooper_up.models.CentroModelo;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BorrarAlumno extends AppCompatActivity {


    Button btnBorrar;
    TextInputEditText dniBorrar;

    CentroModelo centro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_alumno);

        btnBorrar = findViewById(R.id.btnBorrar);
        dniBorrar = findViewById(R.id.dniBorrar);

        if (getIntent() != null && getIntent().hasExtra("centro")) {
            centro = (CentroModelo) getIntent().getSerializableExtra("centro");
        }

        btnBorrar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                String dni = dniBorrar.getText().toString();

                Toast.makeText(BorrarAlumno.this, dni, Toast.LENGTH_SHORT).show();

                ApiAdapter apiAdapter = ApiAdapter.getInstance();
                ApiService apiService = apiAdapter.getApiService();

                Call<Integer> call = apiService.deleteAlumno(dni);

                call.enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {

                        Integer respuesta = response.body();

                        if(response.isSuccessful()){
                            if (respuesta == 1){
                                Toast.makeText(BorrarAlumno.this, "Alumno borrado correctamente", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(BorrarAlumno.this, MainActivityCentro.class);
                                intent.putExtra("centro", centro);
                                startActivity(intent);
                            }else {
                                Toast.makeText(BorrarAlumno.this, "Introduzca un DNI válido", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(BorrarAlumno.this, "No successfull", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Toast.makeText(BorrarAlumno.this, "Error al borrar", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        ImageButton btnAtras = findViewById(R.id.volverAlumnoBorrar);

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BorrarAlumno.this, VerAlumnos.class);
                intent.putExtra("centro", centro);
                startActivity(intent);
            }
        });
    }
}