package com.example.cookingguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginScreenFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 1. Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.loginscreen_fragment, container, false);

        // 2. Initialize Buttons using v.findViewById
        Button registerButton = v.findViewById(R.id.registerButtom);
        Button backButton = v.findViewById(R.id.backButton);
        Button loginButton = v.findViewById(R.id.loginButton1);

        // --- REGISTER BUTTON LOGIC ---
        registerButton.setOnClickListener(n -> {
            // Move forward to Screen 3 (Register)
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new RegisterScreenFragment())
                    .addToBackStack(null)
                    .commit();
        });

        // --- BACK BUTTON LOGIC ---
        backButton.setOnClickListener(n ->
        {
            // This takes the user back to Screen 1 (Welcome)
            getParentFragmentManager().popBackStack();
        });

        // --- LOGIN BUTTON LOGIC ---
        loginButton.setOnClickListener(n -> {

        });

        return v;
    }
}