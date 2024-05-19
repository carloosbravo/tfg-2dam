package com.example.cooper_up;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrarAlumno extends AppCompatActivity {

    private EditText etNombre, etContrasena, etTelefono, etEmail, etValoracion, etExpediente;
    private Button buttonRegistrar;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_alumno);

        etNombre = findViewById(R.id.et_nombre);
        etContrasena = findViewById(R.id.et_contrasena);
        etTelefono = findViewById(R.id.et_telefono);
        etEmail = findViewById(R.id.et_email);
        etValoracion = findViewById(R.id.et_valoracion);
        etExpediente = findViewById(R.id.et_expediente);
        buttonRegistrar = findViewById(R.id.button);

        apiService = ApiAdapter.getInstance().getApiService();

        // Accion cuando se presione el boton
        buttonRegistrar.setOnClickListener(v -> registrarAlumno());
    }

    private void registrarAlumno() {
        String nombre = etNombre.getText().toString();
        String contrasena = etContrasena.getText().toString();
        String telefono = etTelefono.getText().toString();
        String email = etEmail.getText().toString();
        String valoracion = etValoracion.getText().toString();
        String expediente = etExpediente.getText().toString();

        if (nombre.isEmpty() || contrasena.isEmpty() || telefono.isEmpty() || email.isEmpty() || valoracion.isEmpty()) {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        AlumnoModel nuevoAlumno = new AlumnoModel();
        nuevoAlumno.setNombre(nombre);
        nuevoAlumno.setContraseña(contrasena);
        nuevoAlumno.setTelefono(telefono);
        nuevoAlumno.setEmail(email);
        nuevoAlumno.setValoracion_profesorado(valoracion);
        nuevoAlumno.setExpediente_academico(expediente);
        Call<AlumnoModel> call = apiService.register(nuevoAlumno);
        call.enqueue(new Callback<AlumnoModel>() {
            @Override
            public void onResponse(Call<AlumnoModel> call, Response<AlumnoModel> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(RegistrarAlumno.this, "Alumno registrado con éxito", Toast.LENGTH_SHORT).show();
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
