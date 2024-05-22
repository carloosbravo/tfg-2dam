package com.example.cooper_up.logins;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cooper_up.mains.MainActivityCentro;
import com.example.cooper_up.R;
import com.example.cooper_up.models.CentroModelo;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginCentro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_centro);

        TextInputEditText correo = findViewById(R.id.userametextCentro);
        TextInputEditText contra = findViewById(R.id.contratextCentro);
        Button login_btn = findViewById(R.id.loginbtnCentro);

        ApiAdapter apiAdapter = ApiAdapter.getInstance();
        ApiService apiService = apiAdapter.getApiService();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correoIntro = correo.getText().toString();
                String contraIntro = contra.getText().toString();

                if (correoIntro.isEmpty() || contraIntro.isEmpty()) {
                    Toast.makeText(LoginCentro.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                Call<CentroModelo> call = apiService.logInCentro(correoIntro);

                call.enqueue(new Callback<CentroModelo>() {
                    @Override
                    public void onResponse(Call<CentroModelo> call, Response<CentroModelo> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            CentroModelo centro = response.body();
                            String contraEmpresa = centro.getContraseña();

                            if (contraEmpresa != null && contraEmpresa.equals(contraIntro)) {
                                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putInt("idCentro", centro.getId());
                                editor.apply();
                                Intent intent = new Intent(LoginCentro.this, MainActivityCentro.class);
                                intent.putExtra("centro", centro);
                                startActivity(intent);
                            } else {
                                Toast.makeText(LoginCentro.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(LoginCentro.this, "Invalid response from server: " + response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<CentroModelo> call, Throwable t) {
                        Log.e(TAG, "Server error: " + t.getMessage(), t);

                        Toast.makeText(LoginCentro.this, "Server error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}