package com.example.cooper_up;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditarUsuario extends AppCompatActivity {
    private AlumnoModel alumno;

    // Declarar los inputs y el botón
    private TextInputEditText nombreEditarInput;
    private TextInputEditText contrasenaEditarInput;
    private TextInputEditText repetirContrasenaEditarInput;
    private TextInputEditText emailEditarInput;
    private TextInputEditText telefonoEditarInput;
    private Button actualizarUsuarioBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);

        // Obtener el objeto AlumnoModel del Intent
        if (getIntent() != null && getIntent().hasExtra("alumno")) {
            alumno = (AlumnoModel) getIntent().getSerializableExtra("alumno");
        }

        // Asignar vistas a las variables
        nombreEditarInput = findViewById(R.id.nombreEditarInput);
        contrasenaEditarInput = findViewById(R.id.contrasenaEditarInput);
        repetirContrasenaEditarInput = findViewById(R.id.repetirContrasenaEditarInput);
        emailEditarInput = findViewById(R.id.emailEditarInput);
        telefonoEditarInput = findViewById(R.id.telefonoEditarInput);
        actualizarUsuarioBoton = findViewById(R.id.actualizarUsuarioBoton);

        // Rellenar los campos con los datos del alumno si no es nulo
        if (alumno != null) {
            nombreEditarInput.setText(alumno.getNombre().toString());
            emailEditarInput.setText(alumno.getEmail().toString());
            telefonoEditarInput.setText(alumno.getTelefono().toString());
        }

        // Configurar el botón para volver al perfil
        ImageButton volverPerfilButton = findViewById(R.id.volverPerfilButton);
        volverPerfilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarUsuario.this, MainActivity.class); // Reemplaza 'ProfileActivity' con la actividad a la que quieres ir
                startActivity(intent);
            }
        });

        // Configurar el botón de actualizar
        actualizarUsuarioBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validar y actualizar los datos
                String nuevoNombre = nombreEditarInput.getText().toString();
                String nuevoEmail = emailEditarInput.getText().toString();
                String nuevoTelefono = telefonoEditarInput.getText().toString();
                String nuevaContrasena = contrasenaEditarInput.getText().toString();
                String repetirContrasena = repetirContrasenaEditarInput.getText().toString();

                if (nuevaContrasena.equals(repetirContrasena)) {
                    // Actualizar el objeto AlumnoModel
                    alumno.setNombre(nuevoNombre);
                    alumno.setEmail(nuevoEmail);
                    alumno.setTelefono(nuevoTelefono);
                    alumno.setContraseña(nuevaContrasena);

                    Log.d("Alumno",alumno.getId() +"");

                    // Llamada a la API para actualizar los datos
                    ApiService apiService = ApiAdapter.getInstance().getApiService();
                    Call<AlumnoModel> call = apiService.register(alumno);
                    call.enqueue(new Callback<AlumnoModel>() {
                        @Override
                        public void onResponse(Call<AlumnoModel> call, Response<AlumnoModel> response) {
                            if (response.isSuccessful()) {
                                // Manejar la respuesta de la API
                                Toast.makeText(EditarUsuario.this, "Datos actualizados exitosamente", Toast.LENGTH_SHORT).show();
                                // Cambiar a MainActivity
                                Intent intent = new Intent(EditarUsuario.this, MainActivity.class);
                                intent.putExtra("alumno", alumno);
                                startActivity(intent);
                            } else {
                                // Manejar error en la respuesta de la API
                                Toast.makeText(EditarUsuario.this, "Error al actualizar los datos", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<AlumnoModel> call, Throwable t) {
                            // Manejar error en la llamada a la API
                            Toast.makeText(EditarUsuario.this, "Error en la conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    // Mostrar un mensaje de error si las contraseñas no coinciden
                    Toast.makeText(EditarUsuario.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
