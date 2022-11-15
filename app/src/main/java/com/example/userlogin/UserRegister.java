package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserRegister extends AppCompatActivity {
    EditText fullname, emailaddress, password;
    Button button;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        fullname = findViewById(R.id.fullname);
        emailaddress = findViewById(R.id.emailaddress);
        password = findViewById(R.id.password);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fullname.getText().toString().isEmpty() || emailaddress.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                    Toast.makeText(UserRegister.this, "please enter your all details", Toast.LENGTH_SHORT).show();
                } else {

                    if (emailaddress.getText().toString().matches(emailPattern)) {

                        if (password.getText().toString().length() >= 6) {
                            Toast.makeText(UserRegister.this, "All good , user created.... ", Toast.LENGTH_SHORT).show();
                            storeUserInfo();
                        } else {
                            Toast.makeText(UserRegister.this, "Password length most be greater then 6", Toast.LENGTH_SHORT).show();
                        }


                    } else {
                        Toast.makeText(UserRegister.this, "Input valid email address", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void storeUserInfo() {

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("UserReg", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("fullname", fullname.getText().toString());
        editor.putString("emailadderss", emailaddress.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.apply();
        editor.commit();
    }
}