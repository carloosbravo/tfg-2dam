package com.example.cooper_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.cooper_up.mains.MainActivity;
import com.example.cooper_up.pulsables.AlumnoPulsar;

public class Curriculum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curriculum);
        ImageButton volverHomeButton = findViewById(R.id.volverHomeTV);


        volverHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Curriculum.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}