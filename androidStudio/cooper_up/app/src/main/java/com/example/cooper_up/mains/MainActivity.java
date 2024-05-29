package com.example.cooper_up.mains;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.cooper_up.R;
import com.example.cooper_up.fragmentsAlumno.PracticasSolicitadasFragment;
import com.example.cooper_up.fragmentsAlumno.HomeFragment;
import com.example.cooper_up.fragmentsAlumno.ProfileFragment;
import com.example.cooper_up.fragmentsEmpresa.AlumnosInteresadosFragment;
import com.example.cooper_up.fragmentsEmpresa.ProfileEmpresaFragment;
import com.example.cooper_up.models.AlumnoModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigation;

    // Objeto AlumnoModel
    private AlumnoModel alumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alumno = (AlumnoModel) getIntent().getSerializableExtra("alumno");

        navigation = findViewById(R.id.bottomNavView);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeFragment());
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        int itemId = item.getItemId();

        // Inicializar fragmentos si es necesario
        if (itemId  == R.id.navHome) {
            fragment = new HomeFragment();
        }else if (itemId == R.id.navPracticas) {
            fragment = new PracticasSolicitadasFragment();
        } else if (itemId == R.id.navProfile) {
            fragment = new ProfileFragment();
        }
        if (fragment != null) {
            loadFragment(fragment);
            return true;
        }
        return false;
    }
    private void loadFragment(Fragment fragment){
        Bundle bundle = new Bundle();
        bundle.putSerializable("alumno", alumno);
        fragment.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
    }

}
