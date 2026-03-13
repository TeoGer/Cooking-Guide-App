package com.example.cookingguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WelcomeScreenFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 1. "Inflate" the XML layout (This is the Fragment's version of setContentView)
        View v = inflater.inflate(R.layout.welcomescreen_fragment, container, false);

        // 2. Find the button (Notice we use v.findViewById because the button is inside 'v')
        Button myButton = v.findViewById(R.id.loginButton);

        myButton.setOnClickListener(view -> {
            // 3. Navigation (This is the "Container Approach" replacement for Intent)
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new LoginScreenFragment()) // Go to Screen 2
                    .addToBackStack(null) // Allows user to use the 'Back' button
                    .commit();
        });

        return v;
    }
}