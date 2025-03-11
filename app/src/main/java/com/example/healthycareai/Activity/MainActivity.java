package com.example.healthycareai.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.healthycareai.Fragment.HomeFragment;
import com.example.healthycareai.R;
import com.example.healthycareai.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
     ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initListFrament();
    }

    private void initListFrament() {
        getSupportFragmentManager().beginTransaction()
                .replace(binding.viewFragment.getId(), new HomeFragment())
                .commit();
        BottomNavigationView menu = findViewById(R.id.menu);
        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId()){
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;

                }
                return false;
            }
        });

    }
}