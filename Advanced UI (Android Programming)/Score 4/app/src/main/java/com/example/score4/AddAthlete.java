package com.example.score4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.score4.LocalDB.AthleteManageData;

public class AddAthlete extends Fragment {

    private EditText add_first_name_input;
    private EditText add_last_name_input;
    private EditText add_city_input;
    private EditText add_country_input;
    private EditText add_birth_year_input;
    private EditText add_sport_input;
    private EditText add_tid_input;

    private Button add_a_new_athlete_button_id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_athlete_fragment, container, false);

        add_first_name_input = view.findViewById(R.id.add_first_name_input);
        add_last_name_input = view.findViewById(R.id.add_last_name_input);
        add_city_input = view.findViewById(R.id.add_city_input);
        add_country_input = view.findViewById(R.id.add_country_input);
        add_birth_year_input = view.findViewById(R.id.add_birth_year_input);
        add_sport_input = view.findViewById(R.id.add_sport_input);
        add_tid_input = view.findViewById(R.id.add_tid_input);

        add_a_new_athlete_button_id = view.findViewById(R.id.add_a_new_athlete_button_id);

        add_a_new_athlete_button_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AthleteManageData.insertAthlete(
                        Integer.valueOf(add_tid_input.getText().toString()),
                        add_first_name_input.getText().toString(),
                        add_last_name_input.getText().toString(),
                        add_city_input.getText().toString(),
                        add_country_input.getText().toString(),
                        Integer.valueOf(add_sport_input.getText().toString()),
                        Integer.valueOf(add_birth_year_input.getText().toString()),
                        0,
                        0,
                        getActivity()
                );

                Toast.makeText(getActivity(),"Athlete Inserted!",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
