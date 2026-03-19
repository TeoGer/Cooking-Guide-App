//Να τσεκάρω τα findViewById

package com.example.cookingguide;

import java.util.ArrayList;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
    ConstraintLayout zymarikaLayout;
    ConstraintLayout soupesLayout;
    ConstraintLayout salatesLayout;
    ConstraintLayout glykaLayout;
    ConstraintLayout zymarika1Layout;
    ConstraintLayout zymarika2Layout;
    ConstraintLayout zymarika3Layout;
    ConstraintLayout zymarika4Layout;
    TextView loginWelcomeTextView;
    TextView TextViewZymarica1;
    TextView TextViewZymarica2;
    TextView TextViewSoupes1;
    TextView TextViewSoupes2;
    TextView TextViewSalates1;
    TextView TextViewSalates2;
    TextView TextViewGlyka1;
    TextView TextViewGlyka2;
    TextView TextViewzymarika1Title1;
    TextView TextViewzymarika1Title2;
    TextView TextViewzymarika2Title1;
    TextView TextViewzymarika2Title2;
    TextView TextViewzymarika3Title1;
    TextView TextViewzymarika3Title2;
    TextView TextViewzymarika4Title1;
    TextView TextViewzymarika4Title2;


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
        zymarikaLayout = findViewById(R.id.zymaricaLayout);
        soupesLayout = findViewById(R.id.soupesLayout);
        salatesLayout = findViewById(R.id.salatesLayout);
        glykaLayout = findViewById(R.id.glykaLayout);
        zymarika1Layout = findViewById(R.id.zymarika1Layout);
        zymarika2Layout = findViewById(R.id.zymarika2Layout);
        zymarika3Layout = findViewById(R.id.zymarika3Layout);
        zymarika4Layout = findViewById(R.id.zymarika4Layout);

        //The screens at startup
        welcomeLayout.setVisibility(View.VISIBLE);
        loginLayout.setVisibility(View.GONE);
        registerLayout.setVisibility(View.GONE);
        loginWelcomeLayout.setVisibility(View.GONE);
        zymarikaLayout.setVisibility(View.GONE);
        soupesLayout.setVisibility(View.GONE);
        salatesLayout.setVisibility(View.GONE);
        glykaLayout.setVisibility(View.GONE);
        zymarika1Layout.setVisibility(View.GONE);
        zymarika2Layout.setVisibility(View.GONE);
        zymarika3Layout.setVisibility(View.GONE);
        zymarika4Layout.setVisibility(View.GONE);

        //Here I initialize the TextViews
        loginWelcomeTextView = findViewById(R.id.loginWelcomeMessage);
        TextViewZymarica1 = findViewById(R.id.textViewZymarika1);
        TextViewZymarica2 = findViewById(R.id.textViewZymarika2);
        TextViewSoupes1 = findViewById(R.id.textViewSoupes1);
        TextViewSoupes2 = findViewById(R.id.textViewSoupes2);
        TextViewSalates1 = findViewById(R.id.textViewSalates1);
        TextViewSalates2 = findViewById(R.id.textViewSalates2);
        TextViewGlyka1 = findViewById(R.id.textViewGlyka1);
        TextViewGlyka2 = findViewById(R.id.textViewGlyka2);
        TextViewzymarika1Title1=findViewById(R.id.zymarika1Title1);
        TextViewzymarika1Title2=findViewById(R.id.zymarika1Title2);
        TextViewzymarika2Title1=findViewById(R.id.zymarika2Title1);
        TextViewzymarika2Title2=findViewById(R.id.zymarika2Title2);
        TextViewzymarika3Title1=findViewById(R.id.zymarika3Title1);
        TextViewzymarika3Title2=findViewById(R.id.zymarika3Title2);
        TextViewzymarika4Title1=findViewById(R.id.zymarika4Title1);
        TextViewzymarika4Title2=findViewById(R.id.zymarika4Title2);





        //The Welcome screen login Button
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> showScreens("login",null));

        //The login screen buttons
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> showScreens("welcome",null));

        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(v -> showScreens("register",null));

        loginUsername = findViewById(R.id.etLoginUsername);
        loginPassword = findViewById(R.id.etLoginPassword);
        loginCheckButton = findViewById(R.id.checkButtonLogin);
        loginCheckButton.setOnClickListener(v -> checkLogin());     //Calls the checkLogin method

        //The register screen buttons
        Button backButtonReg = findViewById(R.id.backButtonReg);
        backButtonReg.setOnClickListener(v -> showScreens("login",null));

        //Button checkButtonReg = findViewById(R.id.checkButtonReg);

        registerUsername = findViewById(R.id.register_username);
        registerPassword = findViewById(R.id.register_password);
        Button registerCheckButton = findViewById(R.id.checkButtonReg);
        registerCheckButton.setOnClickListener(v -> checkRegister());       //Calls the checkRegister method

        //The login Welcome screen buttons
        Button backButtonLoginWelcome = findViewById(R.id.backButtonLoginWelcome);
        backButtonLoginWelcome.setOnClickListener(v -> showScreens("login",null));

        ImageButton zymarikaButton = findViewById(R.id.imageButtonZymarika);
        zymarikaButton.setOnClickListener(v -> showScreens("zymarika",null));

        ImageButton soupesButton = findViewById(R.id.imageButtonSoupes);
        soupesButton.setOnClickListener(v -> showScreens("soupes",null));

        ImageButton salatesButton = findViewById(R.id.imageButtonSalates);
        salatesButton.setOnClickListener(v -> showScreens("salates",null));

        ImageButton glykaButton = findViewById(R.id.imageButtonGlyka);
        glykaButton.setOnClickListener(v -> showScreens("glyka",null));

        //The zymarika screen buttons
        Button backButtonZymarika = findViewById(R.id.backButtonZymarika);
        backButtonZymarika.setOnClickListener(v -> showScreens("loginWelcome",null));

        Button zymarika1Button = findViewById(R.id.zymarikaButton1);
        zymarika1Button.setOnClickListener(v -> showScreens("zymarika1",null));

        Button zymarika2Button = findViewById(R.id.zymarikaButton2);
        zymarika2Button.setOnClickListener(v -> showScreens("zymarika2",null));

        Button zymarika3Button = findViewById(R.id.zymarikaButton3);
        zymarika3Button.setOnClickListener(v -> showScreens("zymarika3",null));

        Button zymarika4Button = findViewById(R.id.zymarikaButton4);
        zymarika4Button.setOnClickListener(v -> showScreens("zymarika4",null));

        //The zymarika1 buttons
        Button backButtonZymarika1 = findViewById(R.id.backButtonZymarika1);
        backButtonZymarika1.setOnClickListener(v -> showScreens("zymarika",null));

        Button zymarika1ButtonSynt = findViewById(R.id.zymarika1ButtonSynt);
        zymarika1ButtonSynt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akispetretzikis.com/recipe/9653/zymarika-me-tyri-krema-kai-kapnisto-solomo"));
            startActivity(intent);
        });

        Button zymarika1ButtonVideo = findViewById(R.id.zymarika1ButtonVideo);
        zymarika1ButtonVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=edkO-QY-Teg"));
            startActivity(intent);
        });

        //The zymarika2 buttons
        Button backButtonZymarika2 = findViewById(R.id.backButtonZymarika2);
        backButtonZymarika2.setOnClickListener(v -> showScreens("zymarika",null));

        Button zymarika2ButtonSynt = findViewById(R.id.zymarika2ButtonSynt);
        zymarika2ButtonSynt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akispetretzikis.com/recipe/9516/lemonato-kotopoulo-giouvetsi"));
            startActivity(intent);
        });

        Button zymarika2ButtonVideo = findViewById(R.id.zymarika2ButtonVideo);
        zymarika2ButtonVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ipba4JlLGqE"));
            startActivity(intent);
        });

        //The zymarica3 buttons
        Button backButtonZymarika3 = findViewById(R.id.backButtonZymarika3);
        backButtonZymarika3.setOnClickListener(v -> showScreens("zymarika",null));

        Button zymarika3ButtonSynt = findViewById(R.id.zymarika3ButtonSynt);
        zymarika3ButtonSynt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akispetretzikis.com/recipe/9487/penes-me-krema-kastano-mpeikon-kai-karamelwmena-kremmydia"));
            startActivity(intent);
        });

        Button zymarika3ButtonVideo = findViewById(R.id.zymarika3ButtonVideo);
        //ΔΕΝ ΕΙΧΕ ΒΙΝΤΕΟ ΜΕ ΣΥΝΤΑΓΗ

        //The zymarika4 buttons
        Button backButtonZymarika4 = findViewById(R.id.backButtonZymarika4);
        backButtonZymarika4.setOnClickListener(v -> showScreens("zymarika",null));

        Button zymarika4ButtonSynt = findViewById(R.id.zymarika4ButtonSynt);
        zymarika4ButtonSynt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akispetretzikis.com/recipe/9408/penes-fournou-me-4-tyria"));
            startActivity(intent);
        });

        Button zymarika4ButtonVideo = findViewById(R.id.zymarika4ButtonVideo);
        zymarika4ButtonVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=DGAEqaxzgN0"));
            startActivity(intent);
        });


        //The soupes screen buttons
        Button backButtonSoupes = findViewById(R.id.backButtonSoupes);
        backButtonSoupes.setOnClickListener(v -> showScreens("loginWelcome",null));

        //The salates screen buttons
        Button backButtonSalates = findViewById(R.id.backButtonSalates);
        backButtonSalates.setOnClickListener(v -> showScreens("loginWelcome",null));

        //The glyka screen buttons
        Button backButtonGlyka = findViewById(R.id.backButtonGlyka);
        backButtonGlyka.setOnClickListener(v -> showScreens("loginWelcome",null));

        //Zymarika scrolling






    }

    void showScreens(String screen, String username)
    {
        welcomeLayout.setVisibility(View.GONE);
        loginLayout.setVisibility(View.GONE);
        registerLayout.setVisibility(View.GONE);
        loginWelcomeLayout.setVisibility(View.GONE);
        zymarikaLayout.setVisibility(View.GONE);
        zymarika1Layout.setVisibility(View.GONE);
        zymarika2Layout.setVisibility(View.GONE);
        zymarika3Layout.setVisibility(View.GONE);
        zymarika4Layout.setVisibility(View.GONE);
        soupesLayout.setVisibility(View.GONE);
        salatesLayout.setVisibility(View.GONE);
        glykaLayout.setVisibility(View.GONE);


        switch(screen)
        {
            case "welcome":
                welcomeLayout.setVisibility(View.VISIBLE);
                break;

            case "login":
                loginLayout.setVisibility(View.VISIBLE);
                break;

            case "register":
                registerLayout.setVisibility(View.VISIBLE);
                break;

            case "loginWelcome":
                loginWelcomeLayout.setVisibility(View.VISIBLE);

                if(username!=null)
                {
                    loginWelcomeTextView.setText("Welcome "+username);
                }
                break;

            case "zymarika":
                zymarikaLayout.setVisibility(View.VISIBLE);
                break;

            case "soupes":
                soupesLayout.setVisibility(View.VISIBLE);
                break;

            case "salates":
                salatesLayout.setVisibility(View.VISIBLE);
                break;

            case "glyka":
                glykaLayout.setVisibility(View.VISIBLE);
                break;

            case "zymarika1":
                zymarika1Layout.setVisibility(View.VISIBLE);
                break;

            case "zymarika2":
                zymarika2Layout.setVisibility(View.VISIBLE);
                break;

            case "zymarika3":
                zymarika3Layout.setVisibility(View.VISIBLE);
                break;

            case "zymarika4":
                zymarika4Layout.setVisibility(View.VISIBLE);
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
            showScreens("loginWelcome",username);
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
        showScreens("welcome",null);
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