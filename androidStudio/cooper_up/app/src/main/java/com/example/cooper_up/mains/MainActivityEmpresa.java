package com.example.cooper_up.mains;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.cooper_up.R;
import com.example.cooper_up.fragmentsEmpresa.AlumnosInteresadosFragment;
import com.example.cooper_up.fragmentsEmpresa.HomeEmpresaFragment;
import com.example.cooper_up.fragmentsEmpresa.ProfileEmpresaFragment;
import com.example.cooper_up.models.EmpresaModelo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivityEmpresa extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigation;
    private EmpresaModelo empresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_empresa);

        empresa = (EmpresaModelo) getIntent().getSerializableExtra("empresa");

        navigation = findViewById(R.id.bottomNavViewCentro);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeEmpresaFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        int itemId = item.getItemId();

        if (itemId == R.id.navHome) {
            fragment = new HomeEmpresaFragment();
        } else if (itemId == R.id.navAlumnos) {
            fragment = new AlumnosInteresadosFragment();
        } else if (itemId == R.id.navProfile) {
            fragment = new ProfileEmpresaFragment();
        }

        if (fragment != null) {
            loadFragment(fragment);
            return true;
        }

        return false;
    }

    private void loadFragment(Fragment fragment) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("empresa", empresa);
        fragment.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayoutCentro, fragment);
        transaction.commit();
    }
}
