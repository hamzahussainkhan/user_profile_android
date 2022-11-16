package com.example.userlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView TV_signup;
    EditText emailaddress, password;
    Button button;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    DrawerLayout drawerlayout;
    ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TV_signup = findViewById(R.id.TV_signup);
        emailaddress = findViewById(R.id.emailaddress);
        password = findViewById(R.id.password);
        button = findViewById(R.id.button);
        drawerlayout = findViewById(R.id.drawerlayout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerlayout, R.string.nav_open, R.string.nav_close);

        drawerlayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TV_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, UserRegister.class);
                startActivity(intent);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (emailaddress.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "please enter your all details", Toast.LENGTH_SHORT).show();
                } else {
                    if (emailaddress.getText().toString().matches(emailPattern)) {
                        if (password.getText().toString().length() >= 6) {
                            Toast.makeText(MainActivity.this, "All good , user created.... ", Toast.LENGTH_SHORT).show();
                            storeUserInfo();
                        } else {
                            Toast.makeText(MainActivity.this, "Password length most be greater then 6", Toast.LENGTH_SHORT).show();
                        }


                    } else {
                        Toast.makeText(MainActivity.this, "Input valid email address", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void storeUserInfo() {

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("UserReg", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("emailadderss", emailaddress.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.apply();
        editor.commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        switch (menuItem.getItemId()) {
            case R.id.profile:
                Intent intent = new Intent(MainActivity.this, userprofile.class);
                startActivity(intent);

                break;
            case R.id.register:
                Toast.makeText(this, "Register Click", Toast.LENGTH_SHORT).show();
                break;

        }


        drawerlayout.closeDrawer(GravityCompat.START);

        return true;
    }
}

