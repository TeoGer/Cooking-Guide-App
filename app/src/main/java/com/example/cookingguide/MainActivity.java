package com.example.cookingguide;

import java.util.ArrayList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    //Variables to store the layouts
    ConstraintLayout welcomeLayout;
    ConstraintLayout loginLayout;
    ConstraintLayout registerLayout;

    ConstraintLayout loginWelcomeLayout;
    TextView loginWelcomeTextView;

    //User data storage and file to store the data
    static ArrayList<String[]> userinfo = new ArrayList<>();
    static final String FILENAME = "userinfo.json";

    //Login Resources
    EditText loginUsername, loginPassword;
    Button loginCheckButton;

    //Register resources
    EditText registerUsername, registerPassword;
    Button registerCheckButton;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Load user data
        loadUserData();


        //Here the layouts are connected
        welcomeLayout = findViewById(R.id.welcomeLayout);
        loginLayout = findViewById(R.id.loginLayout);
        registerLayout = findViewById(R.id.registerLayout);
        loginWelcomeLayout = findViewById(R.id.loginWelcomeLayout);

        //The screens at startup
        welcomeLayout.setVisibility(View.VISIBLE);
        loginLayout.setVisibility(View.GONE);
        registerLayout.setVisibility(View.GONE);
        loginWelcomeLayout.setVisibility(View.GONE);

        //Here I initialize the TextViews
        loginWelcomeTextView = findViewById(R.id.loginWelcomeTextView);



        //The Welcome screen login Button
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> showScreens("login"));

        //The login screen buttons
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> showScreens("welcome"));

        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(v -> showScreens("register"));

        loginUsername = findViewById(R.id.etLoginUsername);
        loginPassword = findViewById(R.id.etLoginPassword);
        loginCheckButton = findViewById(R.id.checkButtonLogin);
        loginCheckButton.setOnClickListener(v -> checkLogin());     //Calls the checkLogin method

        //The register screen buttons
        Button backButtonReg = findViewById(R.id.backButtonReg);
        backButtonReg.setOnClickListener(v -> showScreens("login"));

        //Button checkButtonReg = findViewById(R.id.checkButtonReg);

        registerUsername = findViewById(R.id.register_username);
        registerPassword = findViewById(R.id.register_password);
        Button registerCheckButton = findViewById(R.id.checkButtonReg);
        registerCheckButton.setOnClickListener(v -> checkRegister());       //Calls the checkRegister method



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

            case "loginWelcome":
                welcomeLayout.setVisibility(View.GONE);
                loginLayout.setVisibility(View.GONE);
                registerLayout.setVisibility(View.GONE);
                loginWelcomeLayout.setVisibility(View.VISIBLE);
                break;
        }
    }

    //Login logic
    private void checkLogin()
    {
        String username = loginUsername.getText().toString().trim();
        String password = loginPassword.getText().toString().trim();

        boolean found=false;
        for(String[] user : userinfo)
        {
            if(user[0].equals(username) && user[1].equals(password))
            {
                found=true;
                break;
            }
        }

        if(found)   //If the user data is correct it returns to welcome page
        {
            Toast.makeText(this,"Welcome!",Toast.LENGTH_SHORT).show();
            showScreens("loginWelcome");
        }
        else
        {
            Toast.makeText(this,"~~Invalid username or password~~",Toast.LENGTH_SHORT).show();
        }

    }


    //Register logic
    private void checkRegister()
    {
        String username = registerUsername.getText().toString().trim();
        String password = registerPassword.getText().toString().trim();

        if(username.isEmpty() || password.isEmpty())
        {
            Toast.makeText(this,"Fill all the fields!",Toast.LENGTH_SHORT).show();
            return;
        }

        //check for username availability
        for(String[] user : userinfo)
        {
            if(user[0].equals(username))
            {
                Toast.makeText(this,"Username is already in use!",Toast.LENGTH_SHORT).show();
                return;
            }
        }

        //Add a new user
        userinfo.add(new String[]{username,password});
        saveUserData();
        Toast.makeText(this,"Successful registration",Toast.LENGTH_SHORT).show();
        //When the new user gets added show the welcome screen again
        showScreens("welcome");
    }


    //File management
    private void saveUserData()
    {
        JSONArray jsonArray = new JSONArray();
        for(String[] user : userinfo)
        {
            JSONArray inner = new JSONArray();
            inner.put(user[0]);         //Here goes the username
            inner.put(user[1]);         //Here goes the password
            jsonArray.put(inner);
        }

        File file = new File(getFilesDir(), FILENAME);
        try(FileWriter writer = new FileWriter(file))
        {
            writer.write(jsonArray.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    private void loadUserData()
    {
        File file = new File(getFilesDir(), FILENAME);
        if(!file.exists()) return;

        StringBuilder content = new StringBuilder();
        try(FileReader reader = new FileReader(file))
        {
            int q;
            while((q=reader.read()) != -1)
            {
                content.append((char) q);
            }

            JSONArray jsonArray = new JSONArray(content.toString());
            userinfo.clear();
            for(int i=0; i<jsonArray.length();i++)
            {
                JSONArray inner = jsonArray.getJSONArray(i);
                String username = inner.getString(0);       //Here goes the username
                String password = inner.getString(1);       //Here goes the password
                userinfo.add(new String[]{username, password});
            }
        }
        catch(IOException | JSONException e)            //Because i use JSONArray i need the JSONException in the catch
        {
            e.printStackTrace();
        }
    }

}