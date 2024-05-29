package com.example.cooper_up;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cooper_up.mains.MainActivityCentro;
import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.models.CentroModelo;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrarAlumno extends AppCompatActivity {

    private EditText etNombre, etContrasena, etTelefono, etEmail, etdni, etGrado;
    private Button buttonRegistrar;

    private ImageButton btnAtras;
    private ApiService apiService;
    private CentroModelo centro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_alumno);

        etNombre = findViewById(R.id.et_nombre);
        etContrasena = findViewById(R.id.et_contrasena);
        etTelefono = findViewById(R.id.et_telefono);
        etEmail = findViewById(R.id.et_email);
        etdni = findViewById(R.id.et_dni);
        etGrado = findViewById(R.id.et_grado);
        buttonRegistrar = findViewById(R.id.button);
        btnAtras = findViewById(R.id.btnAtrasRegistroAlumno);


        apiService = ApiAdapter.getInstance().getApiService();

        // Recibir el objeto CentroModelo del Intent
        if (getIntent() != null && getIntent().hasExtra("centro")) {
            centro = (CentroModelo) getIntent().getSerializableExtra("centro");
        }

        // Acción cuando se presione el botón


        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etNombre.getText().toString().isEmpty() || etContrasena.getText().toString().isEmpty() ||
                        etTelefono.getText().toString().isEmpty() || etEmail.getText().toString().isEmpty() ||
                        etdni.getText().toString().isEmpty() || etGrado.getText().toString().isEmpty()){
                    Toast.makeText(RegistrarAlumno.this, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    registrarAlumno();
                }

            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrarAlumno.this, MainActivityCentro.class);
                startActivity(intent);
            }
        });
        //buttonRegistrar.setOnClickListener(v -> registrarAlumno());
    }

    private void registrarAlumno() {
        String nombre = etNombre.getText().toString();
        String contrasena = etContrasena.getText().toString();
        String telefono = etTelefono.getText().toString();
        String email = etEmail.getText().toString();
        String dni = etdni.getText().toString();
        String grado = etGrado.getText().toString();

        AlumnoModel nuevoAlumno = new AlumnoModel();
        nuevoAlumno.setNombre(nombre);
        nuevoAlumno.setContraseña(contrasena);
        nuevoAlumno.setTelefono(telefono);
        nuevoAlumno.setEmail(email);
        nuevoAlumno.setDni(dni);
        nuevoAlumno.setGrado(grado);

        // Establecer el ID del centro desde el objeto CentroModelo
        if (centro != null) {
            nuevoAlumno.setCentro_id(centro.getId());
        }

        Call<AlumnoModel> call = apiService.register(nuevoAlumno);
        call.enqueue(new Callback<AlumnoModel>() {
            @Override
            public void onResponse(Call<AlumnoModel> call, Response<AlumnoModel> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(RegistrarAlumno.this, "Alumno registrado con éxito", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegistrarAlumno.this, MainActivityCentro.class);
                    intent.putExtra("centro", centro); // Pasar el objeto CentroModelo a la actividad MainActivityCentro
                    startActivity(intent);
                } else {
                    Toast.makeText(RegistrarAlumno.this, "Error al registrar alumno", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AlumnoModel> call, Throwable t) {
                Toast.makeText(RegistrarAlumno.this, "Fallo en la conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
