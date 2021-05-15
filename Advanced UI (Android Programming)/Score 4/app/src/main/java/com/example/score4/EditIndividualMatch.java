package com.example.score4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.score4.RemoteDB.UpdateData;

import java.util.Map;


public class EditIndividualMatch extends Fragment {

    Map<String,Object> match;

    private EditText athlete_a_input;
    private EditText athlete_b_input;
    private EditText score_a_input;
    private EditText score_b_input;
    private EditText city_input;
    private EditText country_input;
    private EditText date_input;
    private EditText noa_input;

    private Button edit_save_changes_button_id;


    public EditIndividualMatch() {
        // Required empty public constructor
    }

    public EditIndividualMatch(Map<String, Object> match) {
        this.match = match;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_individual_match, container, false);

        Bundle bundle = getArguments();

        athlete_a_input= view.findViewById(R.id.athlete_a_input);
        athlete_b_input= view.findViewById(R.id.athlete_b_input);
        score_a_input= view.findViewById(R.id.score_a_input);
        score_b_input= view.findViewById(R.id.score_b_input);
        city_input= view.findViewById(R.id.city_input);
        country_input= view.findViewById(R.id.country_input);
        date_input= view.findViewById(R.id.date_input);
        noa_input= view.findViewById(R.id.noa_input);

        athlete_a_input.setText(match.get("athlete_a").toString());
        athlete_b_input.setText(match.get("athlete_b").toString());
        score_a_input.setText(match.get("score_a").toString());
        score_b_input.setText(match.get("score_b").toString());
        city_input.setText(match.get("city").toString());
        country_input.setText(match.get("country").toString());
        date_input.setText(match.get("date").toString());
        noa_input.setText(match.get("num_of_athletes").toString());

        edit_save_changes_button_id = view.findViewById(R.id.edit_save_changes_button_id);
        edit_save_changes_button_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateData.updateSportData(
                        bundle.getString("SportIs"),
                        bundle.getString("DocID"),
                        "athlete_a",
                        athlete_a_input.getText().toString(),
                        getActivity()
                );
                UpdateData.updateSportData(
                        bundle.getString("SportIs"),
                        bundle.getString("DocID"),
                        "athlete_b",
                        athlete_b_input.getText().toString(),
                        getActivity()
                );
                UpdateData.updateSportData(
                        bundle.getString("SportIs"),
                        bundle.getString("DocID"),
                        "score_a",
                        score_a_input.getText().toString(),
                        getActivity()
                );
                UpdateData.updateSportData(
                        bundle.getString("SportIs"),
                        bundle.getString("DocID"),
                        "score_b",
                        score_b_input.getText().toString(),
                        getActivity()
                );
                UpdateData.updateSportData(
                        bundle.getString("SportIs"),
                        bundle.getString("DocID"),
                        "city",
                        city_input.getText().toString(),
                        getActivity()
                );
                UpdateData.updateSportData(
                        bundle.getString("SportIs"),
                        bundle.getString("DocID"),
                        "country",
                        country_input.getText().toString(),
                        getActivity()
                );
                UpdateData.updateSportData(
                        bundle.getString("SportIs"),
                        bundle.getString("DocID"),
                        "date",
                        date_input.getText().toString(),
                        getActivity()
                );
                UpdateData.updateSportData(
                        bundle.getString("SportIs"),
                        bundle.getString("DocID"),
                        "num_of_athletes",
                        noa_input.getText().toString(),
                        getActivity()
                );

                Toast.makeText(getActivity(),"Individual Match Updated!",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}