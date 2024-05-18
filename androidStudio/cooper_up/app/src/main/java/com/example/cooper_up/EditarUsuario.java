package com.example.cooper_up;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.cooper_up.fragments.ProfileFragment;

public class EditarUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);

        ImageButton volverPerfilButton = findViewById(R.id.volverPerfilButton);
        volverPerfilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarUsuario.this, MainActivity.class);  // Reemplaza 'ProfileActivity' con la actividad a la que quieres ir
                startActivity(intent);
            }
        });
    }
}
