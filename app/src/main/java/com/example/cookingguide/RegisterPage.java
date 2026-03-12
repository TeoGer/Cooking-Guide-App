package com.example.cookingguide;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.register_page);


        Button checkB = findViewById(R.id.checkButtonReg);
        checkB.setOnClickListener(n ->
        {
            Intent intent=new Intent (RegisterPage.this, WelcomePage.class);

            startActivity(intent);
        });

        Button backButton = findViewById(R.id.backButtonReg);
        backButton.setOnClickListener(n ->
        {
            Intent intentBack = new Intent(RegisterPage.this, LoginPage.class);

            startActivity(intentBack);
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}