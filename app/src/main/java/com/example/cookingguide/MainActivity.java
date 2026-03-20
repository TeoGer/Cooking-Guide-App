package com.example.cookingguide;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
    ScrollView loginWelcomeLayout;
    ScrollView zymarikaLayout;
    ScrollView soupesLayout;
    ScrollView salatesLayout;
    ScrollView glykaLayout;
    ScrollView zymarika1Layout;
    ScrollView zymarika2Layout;
    ScrollView zymarika3Layout;
    ScrollView zymarika4Layout;
    ScrollView soupes1Layout;
    ScrollView soupes2Layout;
    ScrollView soupes3Layout;
    ScrollView soupes4Layout;
    ScrollView salates1Layout;
    ScrollView salates2Layout;
    ScrollView salates3Layout;
    ScrollView salates4Layout;
    ScrollView glyka1Layout;
    ScrollView glyka2Layout;
    ScrollView glyka3Layout;
    ScrollView glyka4Layout;



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
    TextView TextViewsoupes1Title1;
    TextView TextViewsoupes1Title2;
    TextView TextViewsoupes2Title1;
    TextView TextViewsoupes2Title2;
    TextView TextViewsoupes3Title1;
    TextView TextViewsoupes3Title2;
    TextView TextViewsoupes4Title1;
    TextView TextViewsoupes4Title2;
    TextView TextViewsalates1Title1;
    TextView TextViewsalates1Title2;
    TextView TextViewsalates2Title1;
    TextView TextViewsalates2Title2;
    TextView TextViewsalates3Title1;
    TextView TextViewsalates3Title2;
    TextView TextViewsalates4Title1;
    TextView TextViewsalates4Title2;
    TextView TextViewglyka1Title1;
    TextView TextViewglyka1Title2;
    TextView TextViewglyka2Title1;
    TextView TextViewglyka2Title2;
    TextView TextViewglyka3Title1;
    TextView TextViewglyka3Title2;
    TextView TextViewglyka4Title1;
    TextView TextViewglyka4Title2;


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
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // handle orientation change
    }


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
        soupes1Layout = findViewById(R.id.soupes1Layout);
        soupes2Layout = findViewById(R.id.soupes2Layout);
        soupes3Layout = findViewById(R.id.soupes3Layout);
        soupes4Layout = findViewById(R.id.soupes4Layout);
        salates1Layout = findViewById(R.id.salates1Layout);
        salates2Layout = findViewById(R.id.salates2Layout);
        salates3Layout = findViewById(R.id.salates3Layout);
        salates4Layout = findViewById(R.id.salates4Layout);
        glyka1Layout = findViewById(R.id.glyka1Layout);
        glyka2Layout = findViewById(R.id.glyka2Layout);
        glyka3Layout = findViewById(R.id.glyka3Layout);
        glyka4Layout = findViewById(R.id.glyka4Layout);


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
        soupes1Layout.setVisibility(View.GONE);
        soupes2Layout.setVisibility(View.GONE);
        soupes3Layout.setVisibility(View.GONE);
        soupes4Layout.setVisibility(View.GONE);
        salates1Layout.setVisibility(View.GONE);
        salates2Layout.setVisibility(View.GONE);
        salates3Layout.setVisibility(View.GONE);
        salates4Layout.setVisibility(View.GONE);
        glyka1Layout.setVisibility(View.GONE);
        glyka2Layout.setVisibility(View.GONE);
        glyka3Layout.setVisibility(View.GONE);
        glyka4Layout.setVisibility(View.GONE);

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

        TextViewsoupes1Title1=findViewById(R.id.soupes1Title1);
        TextViewsoupes1Title2=findViewById(R.id.soupes1Title2);
        TextViewsoupes2Title1=findViewById(R.id.soupes2Title1);
        TextViewsoupes2Title2=findViewById(R.id.soupes2Title2);
        TextViewsoupes3Title1=findViewById(R.id.soupes3Title1);
        TextViewsoupes3Title2=findViewById(R.id.soupes3Title2);
        TextViewsoupes4Title1=findViewById(R.id.soupes4Title1);
        TextViewsoupes4Title2=findViewById(R.id.soupes4Title2);

        TextViewsalates1Title1=findViewById(R.id.salates1Title1);
        TextViewsalates1Title2=findViewById(R.id.salates1Title2);
        TextViewsalates2Title1=findViewById(R.id.salates2Title1);
        TextViewsalates2Title2=findViewById(R.id.salates2Title2);
        TextViewsalates3Title1=findViewById(R.id.salates3Title1);
        TextViewsalates3Title2=findViewById(R.id.salates3Title2);
        TextViewsalates4Title1=findViewById(R.id.salates4Title1);
        TextViewsalates4Title2=findViewById(R.id.salates4Title2);

        TextViewglyka1Title1=findViewById(R.id.glyka1Title1);
        TextViewglyka1Title2=findViewById(R.id.glyka1Title2);
        TextViewglyka2Title1=findViewById(R.id.glyka2Title1);
        TextViewglyka2Title2=findViewById(R.id.glyka2Title2);
        TextViewglyka3Title1=findViewById(R.id.glyka3Title1);
        TextViewglyka3Title2=findViewById(R.id.glyka3Title2);
        TextViewglyka4Title1=findViewById(R.id.glyka4Title1);
        TextViewglyka4Title2=findViewById(R.id.glyka4Title2);





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

        Button soupes1Button = findViewById(R.id.soupesButton1);
        soupes1Button.setOnClickListener(v -> showScreens("soupes1",null));

        Button soupes2Button = findViewById(R.id.soupesButton2);
        soupes2Button.setOnClickListener(v -> showScreens("soupes2",null));

        Button soupes3Button = findViewById(R.id.soupesButton3);
        soupes3Button.setOnClickListener(v -> showScreens("soupes3",null));

        Button soupes4Button = findViewById(R.id.soupesButton4);
        soupes4Button.setOnClickListener(v -> showScreens("soupes4",null));

        //The soupes1 screen buttons
        Button backButtonSoupes1 = findViewById(R.id.backButtonSoupes1);
        backButtonSoupes1.setOnClickListener(v -> showScreens("soupes",null));

        Button soupes1ButtonSynt = findViewById(R.id.soupes1ButtonSynt);
        soupes1ButtonSynt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akispetretzikis.com/recipe/9502/gallikh-kremmydosoupa"));
            startActivity(intent);
        });

        Button soupes1ButtonVideo = findViewById(R.id.soupes1ButtonVideo);
        soupes1ButtonVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Pw1m56hh7IA"));
            startActivity(intent);
        });

        //The soupes2 screen buttons
        Button backButtonSoupes2 = findViewById(R.id.backButtonSoupes2);
        backButtonSoupes2.setOnClickListener(v -> showScreens("soupes",null));

        Button soupes2ButtonSynt = findViewById(R.id.soupes2ButtonSynt);
        soupes2ButtonSynt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akispetretzikis.com/recipe/9411/efkolh-kotosoupa"));
            startActivity(intent);
        });

        Button soupes2ButtonVideo = findViewById(R.id.soupes2ButtonVideo);
        //ΔΕΝ ΕΙΧΕ ΒΙΝΤΕΟ

        //The soupes3 screen buttons
        Button backButtonSoupes3 = findViewById(R.id.backButtonSoupes3);
        backButtonSoupes3.setOnClickListener(v -> showScreens("soupes",null));

        Button soupes3ButtonSynt = findViewById(R.id.soupes3ButtonSynt);
        soupes3ButtonSynt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akispetretzikis.com/recipe/8924/tachinosoupa"));
            startActivity(intent);
        });

        Button soupes3ButtonVideo = findViewById(R.id.soupes3ButtonVideo);
        soupes3ButtonVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=1jkcceEc68k"));
            startActivity(intent);
        });

        //The soupes4 buttons
        Button backButtonSoupes4 = findViewById(R.id.backButtonSoupes4);
        backButtonSoupes4.setOnClickListener(v -> showScreens("soupes",null));

        Button soupes4ButtonSynt = findViewById(R.id.soupes4ButtonSynt);
        soupes4ButtonSynt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akispetretzikis.com/recipe/7046/trahanas-soypa"));
            startActivity(intent);
        });

        Button soupes4ButtonVideo = findViewById(R.id.soupes4ButtonVideo);
        soupes4ButtonVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=8eW6Y11mcIA"));
            startActivity(intent);
        });




        //The salates screen buttons
        Button backButtonSalates = findViewById(R.id.backButtonSalates);
        backButtonSalates.setOnClickListener(v -> showScreens("loginWelcome",null));

        Button salates1Button = findViewById(R.id.salatesButton1);
        salates1Button.setOnClickListener(v -> showScreens("salates1",null));

        Button salates2Button = findViewById(R.id.salatesButton2);
        salates2Button.setOnClickListener(v -> showScreens("salates2",null));

        Button salates3Button = findViewById(R.id.salatesButton3);
        salates3Button.setOnClickListener(v -> showScreens("salates3",null));

        Button salates4Button = findViewById(R.id.salatesButton4);
        salates4Button.setOnClickListener(v -> showScreens("salates4",null));



        //The salates1 screen buttons
        Button backButtonSalates1 = findViewById(R.id.backButtonSalates1);
        backButtonSalates1.setOnClickListener(v -> showScreens("salates",null));

        Button salates1ButtonSynt = findViewById(R.id.salates1ButtonSynt);
        salates1ButtonSynt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akispetretzikis.com/recipe/9520/tampoule-me-kapnisto-tono"));
            startActivity(intent);
        });

        Button salates1ButtonVideo = findViewById(R.id.salates1ButtonVideo);
        salates1ButtonVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=IPovg1yS7ZI"));
            startActivity(intent);
        });

        //The salates2 screen buttons
        Button backButtonSalates2 = findViewById(R.id.backButtonSalates2);
        backButtonSalates2.setOnClickListener(v -> showScreens("salates",null));

        Button salates2ButtonSynt = findViewById(R.id.salates2ButtonSynt);
        salates2ButtonSynt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akispetretzikis.com/recipe/9513/patatosalata-me-sardeles"));
            startActivity(intent);
        });

        Button salates2ButtonVideo = findViewById(R.id.salates2ButtonVideo);
        salates2ButtonVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=l-MOolSnQf0"));
            startActivity(intent);
        });

        //The salates3 screen buttons
        Button backButtonSalates3 = findViewById(R.id.backButtonSalates3);
        backButtonSalates3.setOnClickListener(v -> showScreens("salates",null));

        Button salates3ButtonSynt = findViewById(R.id.salates3ButtonSynt);
        salates3ButtonSynt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akispetretzikis.com/recipe/9186/salata-me-xtapodi-kai-almyra"));
            startActivity(intent);
        });

        Button salates3ButtonVideo = findViewById(R.id.salates3ButtonVideo);
        salates3ButtonVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=_aGEk4jN_TE"));
            startActivity(intent);
        });

        //The salates4 screen buttons
        Button backButtonSalates4 = findViewById(R.id.backButtonSalates4);
        backButtonSalates4.setOnClickListener(v -> showScreens("salates",null));

        Button salates4ButtonSynt = findViewById(R.id.salates4ButtonSynt);
        salates4ButtonSynt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akispetretzikis.com/recipe/9142/salata-me-peponi-kai-prosouto"));
            startActivity(intent);
        });

        Button salates4ButtonVideo = findViewById(R.id.salates4ButtonVideo);
        salates4ButtonVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=zPmRxr2CpYs"));
            startActivity(intent);
        });




        //The glyka screen buttons
        Button backButtonGlyka = findViewById(R.id.backButtonGlyka);
        backButtonGlyka.setOnClickListener(v -> showScreens("loginWelcome",null));

        Button glyka1Button = findViewById(R.id.glykaButton1);
        glyka1Button.setOnClickListener(v -> showScreens("glyka1",null));

        Button glyka2Button = findViewById(R.id.glykaButton2);
        glyka2Button.setOnClickListener(v -> showScreens("glyka2",null));

        Button glyka3Button = findViewById(R.id.glykaButton3);
        glyka3Button.setOnClickListener(v -> showScreens("glyka3",null));

        Button glyka4Button = findViewById(R.id.glykaButton4);
        glyka4Button.setOnClickListener(v -> showScreens("glyka4",null));

        //The glyka1 screen buttons
        Button backButtonGlyka1 = findViewById(R.id.backButtonGlyka1);
        backButtonGlyka1.setOnClickListener(v -> showScreens("glyka",null));

        Button glyka1ButtonSynt = findViewById(R.id.glyka1ButtonSynt);
        glyka1ButtonSynt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akispetretzikis.com/recipe/9644/cookies-karamela"));
            startActivity(intent);
        });

        Button glyka1ButtonVideo = findViewById(R.id.glyka1ButtonVideo);
        glyka1ButtonVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Yj3jDhUO8GY"));
            startActivity(intent);
        });

        //The glyka2 screen button
        Button backButtonGlyka2 = findViewById(R.id.backButtonGlyka2);
        backButtonGlyka2.setOnClickListener(v -> showScreens("glyka",null));

        Button glyka2ButtonSynt = findViewById(R.id.glyka2ButtonSynt);
        glyka2ButtonSynt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akispetretzikis.com/recipe/9622/tachinopites-me-meli"));
            startActivity(intent);
        });

        Button glyka2ButtonVideo = findViewById(R.id.glyka2ButtonVideo);
        glyka2ButtonVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=J8lGyVTnevU"));
            startActivity(intent);
        });

        //The glyka3 screen buttons
        Button backButtonGlyka3 = findViewById(R.id.backButtonGlyka3);
        backButtonGlyka3.setOnClickListener(v -> showScreens("glyka",null));

        Button glyka3ButtonSynt = findViewById(R.id.glyka3ButtonSynt);
        glyka3ButtonSynt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akispetretzikis.com/recipe/9614/carrot-cake-karoto"));
            startActivity(intent);
        });

        Button glyka3ButtonVideo = findViewById(R.id.glyka3ButtonVideo);
        glyka3ButtonVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=vm4CSEFyXdE"));
            startActivity(intent);
        });

        //The glyka4 screen buttons
        Button backButtonGlyka4 = findViewById(R.id.backButtonGlyka4);
        backButtonGlyka4.setOnClickListener(v -> showScreens("glyka",null));

        Button glyka4ButtonSynt = findViewById(R.id.glyka4ButtonSynt);
        glyka4ButtonSynt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akispetretzikis.com/recipe/9611/cheesecake-me-tachini"));
            startActivity(intent);
        });

        Button glyka4ButtonVideo = findViewById(R.id.glyka4ButtonVideo);
        glyka4ButtonVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=hjzkMfkvzdg"));
            startActivity(intent);
        });



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
        soupes1Layout.setVisibility(View.GONE);
        soupes2Layout.setVisibility(View.GONE);
        soupes3Layout.setVisibility(View.GONE);
        soupes4Layout.setVisibility(View.GONE);
        salatesLayout.setVisibility(View.GONE);
        salates1Layout.setVisibility(View.GONE);
        salates2Layout.setVisibility(View.GONE);
        salates3Layout.setVisibility(View.GONE);
        salates4Layout.setVisibility(View.GONE);
        glykaLayout.setVisibility(View.GONE);
        glyka1Layout.setVisibility(View.GONE);
        glyka2Layout.setVisibility(View.GONE);
        glyka3Layout.setVisibility(View.GONE);
        glyka4Layout.setVisibility(View.GONE);


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

            case "soupes1":
                soupes1Layout.setVisibility(View.VISIBLE);
                break;

            case "soupes2":
                soupes2Layout.setVisibility(View.VISIBLE);
                break;

            case "soupes3":
                soupes3Layout.setVisibility(View.VISIBLE);
                break;

            case "soupes4":
                soupes4Layout.setVisibility(View.VISIBLE);
                break;

            case "salates1":
                salates1Layout.setVisibility(View.VISIBLE);
                break;

            case "salates2":
                salates2Layout.setVisibility(View.VISIBLE);
                break;

            case "salates3":
                salates3Layout.setVisibility(View.VISIBLE);
                break;

            case "salates4":
                salates4Layout.setVisibility(View.VISIBLE);
                break;

            case "glyka1":
                glyka1Layout.setVisibility(View.VISIBLE);
                break;

            case "glyka2":
                glyka2Layout.setVisibility(View.VISIBLE);
                break;

            case "glyka3":
                glyka3Layout.setVisibility(View.VISIBLE);
                break;

            case "glyka4":
                glyka4Layout.setVisibility(View.VISIBLE);
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