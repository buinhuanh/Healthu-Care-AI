package com.example.healthycareai.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.healthycareai.Fragment.AnotherFragment;
import com.example.healthycareai.Fragment.HomeFragment;
import com.example.healthycareai.Fragment.MapFragment;
import com.example.healthycareai.Fragment.SettingFragment;
import com.example.healthycareai.R;
import com.example.healthycareai.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

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
                .replace(R.id.viewFragment,new HomeFragment())
                .commit();
        binding.menu.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int mI) {
                Fragment mFragment = null;

                if (mI == R.id.home) {
                    mFragment = new HomeFragment();
                } else if (mI == R.id.search) {
                    mFragment = new AnotherFragment();
                } else if (mI == R.id.bell) {
                    mFragment = new MapFragment();
                } else if (mI == R.id.user) {
                    mFragment = new SettingFragment();
                }

                if (mFragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.viewFragment, mFragment)
                            .commit();
                }
            }

        });

    }
}