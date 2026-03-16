package com.example.cookingguide;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Variables to store the layouts
    ConstraintLayout welcomeLayout;
    ConstraintLayout loginLayout;
    ConstraintLayout registerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        //Here the layouts are connected
        welcomeLayout = findViewById(R.id.welcomeLayout);
        loginLayout = findViewById(R.id.loginLayout);
        registerLayout = findViewById(R.id.registerLayout);

        //The screens at startup
        welcomeLayout.setVisibility(View.VISIBLE);
        loginLayout.setVisibility(View.GONE);
        registerLayout.setVisibility(View.GONE);

        //The Welcome screen login Button
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> showScreens("login"));

        //The login screen buttons
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> showScreens("welcome"));

        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(v -> showScreens("register"));

        //The register screen buttons
        Button backButtonReg = findViewById(R.id.backButtonReg);
        backButtonReg.setOnClickListener(v -> showScreens("login"));

        Button checkButtonReg = findViewById(R.id.checkButtonReg);
        checkButtonReg.setOnClickListener(v -> showScreens("welcome"));



    }

    void showScreens(String screen)
    {
        switch(screen)
        {
            case "welcome":
                welcomeLayout.setVisibility(View.VISIBLE);
                loginLayout.setVisibility(View.GONE);
                registerLayout.setVisibility(View.GONE);
                break;

            case "login":
                welcomeLayout.setVisibility(View.GONE);
                loginLayout.setVisibility(View.VISIBLE);
                registerLayout.setVisibility(View.GONE);
                break;

            case "register":
                welcomeLayout.setVisibility(View.GONE);
                loginLayout.setVisibility(View.GONE);
                registerLayout.setVisibility(View.VISIBLE);
                break;
        }
    }
}