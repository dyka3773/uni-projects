package com.example.score4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.score4.LocalDB.LocalDatabase;

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

        // TODO: Add Parameters
        volleyballButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("SportIs", "Volleyball");

                Sport frag = new Sport();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, frag);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        basketballButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("SportIs", "Basketball");

                Sport frag = new Sport();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, frag);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        footballButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("SportIs", "Football");

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
        getActivity().setTitle("Team Sports");
    }
}