package com.example.cooper_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.cooper_up.mains.MainActivity;
import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.models.CurriculumModel;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Curriculum extends AppCompatActivity {

    private AlumnoModel alumno;
    private CurriculumModel cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curriculum);

        ImageButton volverHomeButton = findViewById(R.id.volverHomeTV);

        EditText grado = findViewById(R.id.estudiosCurriculumTV);
        EditText descripcion = findViewById(R.id.descripcionCurriculumTV);
        EditText lenguajes = findViewById(R.id.lenguajesCurriculumTV);
        EditText idiomas = findViewById(R.id.idiomasCurriculumTV);
        Button btnActualizar = findViewById(R.id.btnActualizarCv);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("alumno")) {
            alumno = (AlumnoModel) intent.getSerializableExtra("alumno");
        }

        ApiAdapter apiAdapter = ApiAdapter.getInstance();
        ApiService apiService = apiAdapter.getApiService();

        Call<CurriculumModel> call = apiService.getCurriculum(alumno.getId());
        call.enqueue(new Callback<CurriculumModel>() {
            @Override
            public void onResponse(Call<CurriculumModel> call, Response<CurriculumModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    cv = response.body();
                    grado.setText(cv.getEstudios() != null ? cv.getEstudios() : "");
                    descripcion.setText(cv.getDescripcion() != null ? cv.getDescripcion() : "");
                    lenguajes.setText(cv.getLenguajes() != null ? cv.getLenguajes() : "");
                    idiomas.setText(cv.getIdiomas() != null ? cv.getIdiomas() : "");
                } else {
                    Toast.makeText(Curriculum.this, "Error: No se pudo obtener el curriculum", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CurriculumModel> call, Throwable t) {
                Toast.makeText(Curriculum.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cv != null) {
                    // Actualizar los datos del objeto cv con los nuevos valores
                    cv.setEstudios(grado.getText().toString());
                    cv.setDescripcion(descripcion.getText().toString());
                    cv.setLenguajes(lenguajes.getText().toString());
                    cv.setIdiomas(idiomas.getText().toString());

                    // Llamada a la API para actualizar el CV
                    Call<CurriculumModel> call2 = apiService.actualizarCV(cv);
                    call2.enqueue(new Callback<CurriculumModel>() {
                        @Override
                        public void onResponse(Call<CurriculumModel> call, Response<CurriculumModel> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(Curriculum.this, "CV actualizado correctamente", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Curriculum.this, "Error al actualizar el CV", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<CurriculumModel> call, Throwable t) {
                            Toast.makeText(Curriculum.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(Curriculum.this, "Error: No se pudo obtener el curriculum", Toast.LENGTH_SHORT).show();
                }
            }
        });

        volverHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Curriculum.this, MainActivity.class);
                intent.putExtra("alumno",alumno);
                startActivity(intent);
            }
        });
    }
}
