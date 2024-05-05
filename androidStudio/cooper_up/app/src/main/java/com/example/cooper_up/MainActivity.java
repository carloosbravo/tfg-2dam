package com.example.cooper_up;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.cooper_up.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottomNavView);
        frameLayout = findViewById(R.id.frameLayout);

        //bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            //@Override
            //public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //int itemId = item.getItemId();
//
                //if (itemId == R.id.navHome) {
//
                //    loadFragment(new HomeFragment(), true);
//
                //} else if (itemId == R.id.navProfile) {
//
                //    loadFragment(new ProfileFragment(), false);
//
                //} else if (itemId == R.id.navAdd){ // nav Add
//
                //    loadFragment(new AddFragment(), false);
//
                //}
                //else {
//
                //    loadFragment(new SearchFragment(), false);
//
                //}
//
                //return true;
       //    }
       //});

    }

   //private void loadFragment(Fragment fragment, boolean isAppInitialized) {

   //    FragmentManager fragmentManager = getSupportFragmentManager();
   //    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

   //    if(isAppInitialized){
   //        fragmentTransaction.add(R.id.frameLayout, fragment);
   //    } else {
   //        fragmentTransaction.replace(R.id.frameLayout, fragment);
   //    }
   //    fragmentTransaction.replace(R.id.frameLayout, fragment);
   //    fragmentTransaction.commit();
   //}
}