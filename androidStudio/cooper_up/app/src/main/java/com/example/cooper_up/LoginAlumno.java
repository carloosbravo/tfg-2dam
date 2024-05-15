package com.example.cooper_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginAlumno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_alumno);

        Button login_btn = findViewById(R.id.loginbtn);

        TextInputEditText correo = findViewById(R.id.userametext);

        TextInputEditText contra = findViewById(R.id.contratext);

        TextView registrarse = findViewById(R.id.registrateTVLogin);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String correoIntro = correo.getText().toString();

                String contraIntro = contra.getText().toString();

                Call<AlumnoModel> call= ApiAdapter.getApiService().logIn(correoIntro);

                call.enqueue(new Callback<AlumnoModel>() {
                    @Override
                    public void onResponse(Call<AlumnoModel> call, Response<AlumnoModel> response) {

                        String contraAlumno = response.body().getContra();
                        Toast.makeText(LoginAlumno.this, contraIntro, Toast.LENGTH_SHORT).show();
                        Toast.makeText(LoginAlumno.this, contraAlumno, Toast.LENGTH_SHORT).show();

                        if(contraAlumno != null) {
                            if(contraAlumno.equals(contraIntro)){
                                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putInt("idAlumno", response.body().getId());
                                editor.commit();
                                Intent intent = new Intent(LoginAlumno.this, MainActivity.class);
                                startActivity(intent);
                            }else if(!contraAlumno.equals(contraIntro)){

                                Toast.makeText(LoginAlumno.this, "CONTRASEÑA INCORRECTA", Toast.LENGTH_SHORT).show();

                            }
                        }else{
                            Toast.makeText(LoginAlumno.this, "SOY NULL", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<AlumnoModel> call, Throwable t) {

                        Toast.makeText(LoginAlumno.this, "SERVER ERROR", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginAlumno.this, EditarUsuario.class);
                startActivity(intent);
            }
        });


    }
}