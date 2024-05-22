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

import com.example.cooper_up.mains.MainActivityEmpresa;
import com.example.cooper_up.R;
import com.example.cooper_up.models.EmpresaModelo;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;
import com.google.android.material.textfield.TextInputEditText;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_empresa);

        TextInputEditText correo = findViewById(R.id.userametextEmpresa);
        TextInputEditText contra = findViewById(R.id.contratextEmpresa);
        Button login_btn = findViewById(R.id.loginbtnEmpresa);

        ApiAdapter apiAdapter = ApiAdapter.getInstance();
        ApiService apiService = apiAdapter.getApiService();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correoIntro = correo.getText().toString();
                String contraIntro = contra.getText().toString();

                if (correoIntro.isEmpty() || contraIntro.isEmpty()) {
                    Toast.makeText(LoginEmpresa.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                Call<EmpresaModelo> call = apiService.logInEmpresa(correoIntro);

                call.enqueue(new Callback<EmpresaModelo>() {
                    @Override
                    public void onResponse(Call<EmpresaModelo> call, Response<EmpresaModelo> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            EmpresaModelo empresa = response.body();
                            String contraEmpresa = empresa.getContraseña();

                            if (contraEmpresa != null && contraEmpresa.equals(contraIntro)) {
                                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putInt("idEmpresa", empresa.getId());
                                editor.apply();
                                Intent intent = new Intent(LoginEmpresa.this, MainActivityEmpresa.class);
                                intent.putExtra("empresa", empresa);
                                startActivity(intent);
                            } else {
                                Toast.makeText(LoginEmpresa.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(LoginEmpresa.this, "Invalid response from server: " + response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<EmpresaModelo> call, Throwable t) {
                        Log.e(TAG, "Server error: " + t.getMessage(), t);

                        Toast.makeText(LoginEmpresa.this, "Server error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
