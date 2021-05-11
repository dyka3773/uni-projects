package com.example.score4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Team_Sports extends Fragment {

    private Button volleyballButton;
    private Button basketballButton;
    private Button footballButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.team_sports_fragment, container, false);

        volleyballButton = view.findViewById(R.id.volleyball_button);
        basketballButton = view.findViewById(R.id.basketball_button);
        footballButton = view.findViewById(R.id.football_button);

        // TODO: Fix the NavController below
        volleyballButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("SportIs", "Volleyball");
                Navigation.findNavController(v).navigate(R.id.navigateToCertainTeam);
            }
        });
        basketballButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("SportIs", "Basketball");
                Navigation.findNavController(v).navigate(R.id.navigateToCertainTeam, bundle);
            }
        });
        footballButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("SportIs", "Football");
                Navigation.findNavController(v).navigate(R.id.navigateToCertainTeam, bundle);
            }
        });

        return view;
    }
}