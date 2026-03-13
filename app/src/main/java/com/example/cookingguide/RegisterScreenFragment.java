package com.example.cookingguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RegisterScreenFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 1. Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.registerscreen_fragment, container, false);

        Button backBtn = v.findViewById(R.id.backButtonReg);

        backBtn.setOnClickListener(view -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new LoginScreenFragment())
                    .commit();
        });

        Button checkBtn = v.findViewById(R.id.checkButtonReg);
        checkBtn.setOnClickListener(view -> {

            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new WelcomeScreenFragment())
                    .commit();
        });

        return v;
    }
}