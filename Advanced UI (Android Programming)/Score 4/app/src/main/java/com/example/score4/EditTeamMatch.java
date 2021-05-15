package com.example.score4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.score4.RemoteDB.UpdateData;

import java.util.Map;

public class EditTeamMatch extends Fragment {


    Map<String,Object> match;

    private EditText team_a_input;
    private EditText team_b_input;
    private EditText score_a_input;
    private EditText score_b_input;
    private EditText city_input;
    private EditText country_input;
    private EditText date_input;
    private EditText sports_input;

    private Button edit_save_changes_button_id;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_team_match, container, false);

        Bundle bundle = getArguments();

        team_a_input= view.findViewById(R.id.team_a_input);
        team_b_input= view.findViewById(R.id.team_b_input);
        score_a_input= view.findViewById(R.id.score_a_input);
        score_b_input= view.findViewById(R.id.score_b_input);
        city_input= view.findViewById(R.id.city_input);
        country_input= view.findViewById(R.id.country_input);
        date_input= view.findViewById(R.id.date_input);
        sports_input= view.findViewById(R.id.sports_input);

        team_a_input.setText(bundle.getString("team_a"));
        team_b_input.setText(bundle.getString("team_b"));
        score_a_input.setText(bundle.getString("score_a"));
        score_b_input.setText(bundle.getString("score_b"));
        city_input.setText(bundle.getString("city"));
        country_input.setText(bundle.getString("country"));
        date_input.setText(bundle.getString("date"));
        sports_input.setText(bundle.getString("sport"));

        edit_save_changes_button_id = view.findViewById(R.id.edit_save_changes_button_id);
        edit_save_changes_button_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateData.updateSportData(
                        bundle.getString("SportIs"),
                        bundle.getString("DocID"),
                        "team_a",
                        team_a_input.getText().toString(),
                        getActivity()
                );
                UpdateData.updateSportData(
                        bundle.getString("SportIs"),
                        bundle.getString("DocID"),
                        "team_b",
                        team_b_input.getText().toString(),
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
                        "sport",
                        sports_input.getText().toString(),
                        getActivity()
                );

                Toast.makeText(getActivity(),"Team Sport Match Updated!",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}