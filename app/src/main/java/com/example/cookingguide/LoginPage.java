package com.example.cookingguide;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_page);


        //The register button puts through to a register page
        Button registerButton=findViewById(R.id.registerButtom);
        registerButton.setOnClickListener(n ->
        {
            Intent intentRegister = new Intent(LoginPage.this, RegisterPage.class);

            startActivity(intentRegister);
        });

        //The back button returns the user to the main page
        Button backButton=findViewById(R.id.backButton);
        backButton.setOnClickListener(n ->
        {
            Intent intentMainP = new Intent(LoginPage.this, WelcomePage.class);

            startActivity(intentMainP);

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}