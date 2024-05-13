package com.example.cooper_up;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.cooper_up.fragments.PracticasSolicitadasFragment;
import com.example.cooper_up.fragments.HomeFragment;
import com.example.cooper_up.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigation;
    private FrameLayout frameLayout;

    // Fragmentos
    private HomeFragment homeFragment;
    private PracticasSolicitadasFragment practicasSolicitadasFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.bottomNavView);
        frameLayout = findViewById(R.id.frameLayout);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setSelectedItemId(R.id.navHome);

        // Inicializar fragmentos
        homeFragment = new HomeFragment();
        practicasSolicitadasFragment = new PracticasSolicitadasFragment();
        profileFragment = new ProfileFragment();

        // Establecer el fragmento inicial
        setFragment(homeFragment);


    }

    // Método para cambiar el fragmento
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture){
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        // Inicializar fragmentos si es necesario
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
        }
        if (practicasSolicitadasFragment == null) {
            practicasSolicitadasFragment = new PracticasSolicitadasFragment();
        }
        if (profileFragment == null) {
            profileFragment = new ProfileFragment();
        }

        // Realizar transacción de fragmentos
        if (itemId == R.id.navHome) {
            setFragment(homeFragment);
            return true;
        } else if (itemId == R.id.navAdd) {
            setFragment(practicasSolicitadasFragment);
            return true;
        } else if (itemId == R.id.navProfile) {
            setFragment(profileFragment);
            return true;
        } else {
            return false;
        }
    }

}
