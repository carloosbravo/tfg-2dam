package com.example.cooper_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cooper_up.mains.MainActivity;
import com.example.cooper_up.mains.MainActivityEmpresa;
import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.models.EmpresaModelo;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModificarEditar extends AppCompatActivity {

    private TextInputEditText nombreEditarInput;
    private TextInputEditText contrasenaEditarInput;
    private TextInputEditText repetirContrasenaEditarInput;
    private TextInputEditText emailEditarInput;
    private TextInputEditText telefonoEditarInput;
    private Button actualizarUsuarioBoton;
    private EmpresaModelo empresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_editar);

        nombreEditarInput = findViewById(R.id.nombreEditarInput);
        contrasenaEditarInput = findViewById(R.id.contrasenaEditarInput);
        repetirContrasenaEditarInput = findViewById(R.id.repetirContrasenaEditarInput);
        emailEditarInput = findViewById(R.id.emailEditarInput);
        telefonoEditarInput = findViewById(R.id.telefonoEditarInput);
        actualizarUsuarioBoton = findViewById(R.id.actualizarUsuarioBoton);

        SharedPreferences sharedPref = this.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        int idEmpresa = sharedPref.getInt("idEmpresa", 1);

        ApiAdapter apiAdapter = ApiAdapter.getInstance();
        ApiService apiService = apiAdapter.getApiService();

        Call<EmpresaModelo> call = apiService.getEmpresaId(idEmpresa);

        call.enqueue(new Callback<EmpresaModelo>() {
            @Override
            public void onResponse(Call<EmpresaModelo> call, Response<EmpresaModelo> response) {
                empresa = response.body();
                nombreEditarInput.setText( response.body().getNombre());
                emailEditarInput.setText( response.body().getEmail());
                telefonoEditarInput.setText( response.body().getTelefono());
            }

            @Override
            public void onFailure(Call<EmpresaModelo> call, Throwable t) {

            }
        });


        actualizarUsuarioBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nuevoNombre = nombreEditarInput.getText().toString();
                String nuevoEmail = emailEditarInput.getText().toString();
                String nuevoTelefono = telefonoEditarInput.getText().toString();
                String nuevaContrasena = contrasenaEditarInput.getText().toString();
                String repetirContrasena = repetirContrasenaEditarInput.getText().toString();

                if (nuevaContrasena.equals(repetirContrasena)) {
                    empresa.setNombre(nuevoNombre);
                    empresa.setEmail(nuevoEmail);
                    empresa.setTelefono(nuevoTelefono);
                    empresa.setContraseña(nuevaContrasena);

                    Call<EmpresaModelo> call = apiService.register(empresa);
                    call.enqueue(new Callback<EmpresaModelo>() {
                        @Override
                        public void onResponse(Call<EmpresaModelo> call, Response<EmpresaModelo> response) {
                            if (response.isSuccessful()) {
                                // Manejar la respuesta de la API
                                Toast.makeText(ModificarEditar.this, "Datos actualizados exitosamente", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ModificarEditar.this, MainActivityEmpresa.class);
                                startActivity(intent);
                            } else {
                                // Manejar error en la respuesta de la API
                                Toast.makeText(ModificarEditar.this, "Error al actualizar los datos", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<EmpresaModelo> call, Throwable t) {
                            // Manejar error en la llamada a la API
                            Toast.makeText(ModificarEditar.this, "Error en la conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    // Mostrar un mensaje de error si las contraseñas no coinciden
                    Toast.makeText(ModificarEditar.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}