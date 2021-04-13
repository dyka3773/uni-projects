package com.example.score4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Sport extends Fragment {


    public Sport() {
        // Required empty public constructor
    }

    //CAN WE MAKE THIS LOAD UP DYNAMICALLY TOO???

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.sport_fragment, container, false);
    }
}