package com.example.score4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Individual_Sports extends Fragment {

    Button boxingButton;
    Button wrestlingButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.individual_sports_fragment, container, false);

        boxingButton = view.findViewById(R.id.boxing_button);
        wrestlingButton = view.findViewById(R.id.wrestling_button);

        boxingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("SportIs", "Boxing");

                Sport frag = new Sport();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, frag);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        wrestlingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("SportIs", "Wrestling");

                Sport frag = new Sport();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, frag);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Individual Sports");
    }
}