package com.asus.taxassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavHostFragment hostFragment = NavHostFragment.create(R.navigation.fragment_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment , hostFragment)
                .setPrimaryNavigationFragment(hostFragment).commit();
    }
}
