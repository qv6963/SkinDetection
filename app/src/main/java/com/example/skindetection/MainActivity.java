package com.example.skindetection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ImageButton loginImgBtn;
    ImageButton aboutImgBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //Performance ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.login:
                        startActivity(new Intent(getApplicationContext(),
                                Login.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),
                                About.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        loginImgBtn = (ImageButton) findViewById(R.id.imageButton);
        loginImgBtn.setOnClickListener((v -> {
            Intent intentLoginImgBtn = new Intent(MainActivity.this, Login.class);
            startActivity(intentLoginImgBtn);
        }));

        aboutImgBtn = (ImageButton) findViewById(R.id.imageButton2);
        aboutImgBtn.setOnClickListener((v -> {
            Intent intentAboutImgBtn = new Intent(MainActivity.this, About.class);
            startActivity(intentAboutImgBtn);
        }));
    }

}