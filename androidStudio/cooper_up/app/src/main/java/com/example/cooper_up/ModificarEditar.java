package com.example.cooper_up;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.models.EmpresaModelo;
import com.google.android.material.textfield.TextInputEditText;

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

        if (getIntent() != null && getIntent().hasExtra("empresa")) {
            empresa = (EmpresaModelo) getIntent().getSerializableExtra("empresa");
        }

        if (empresa != null) {
            nombreEditarInput.setText(empresa.getNombre().toString());
            emailEditarInput.setText(empresa.getEmail().toString());
            telefonoEditarInput.setText(empresa.getTelefono().toString());
        }


    }
}