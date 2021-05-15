package com.example.score4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.score4.LocalDB.TeamManageData;


public class EditTeam extends Fragment {

    private EditText edit_name_input;
    private EditText edit_stadium_name_input;
    private EditText edit_city_input;
    private EditText edit_country_input;
    private EditText edit_birth_year_input;
    private EditText edit_sport_input;
    private EditText edit_tid_input;

    private Button edit_save_changes_button_id;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_edit_team, container, false);

        edit_name_input = view.findViewById(R.id.edit_name_input);
        edit_stadium_name_input = view.findViewById(R.id.edit_stadium_name_input);
        edit_city_input = view.findViewById(R.id.edit_city_input);
        edit_country_input = view.findViewById(R.id.edit_country_input);
        edit_birth_year_input = view.findViewById(R.id.edit_birth_year_input);
        edit_sport_input = view.findViewById(R.id.add_sport_input);
        edit_tid_input = view.findViewById(R.id.add_tid_input);
        edit_save_changes_button_id = view.findViewById(R.id.edit_save_changes_button_id);

        Bundle bundle = this.getArguments();

        if (bundle== null){
            Toast.makeText(getActivity(),"Something went wrong",Toast.LENGTH_SHORT).show();
        }
        else{
            edit_name_input.setText(bundle.getString("teamName"));
            edit_stadium_name_input.setText(bundle.getString("stadiumName"));
            edit_city_input.setText(bundle.getString("city"));
            edit_country_input.setText(bundle.getString("country"));
            edit_birth_year_input.setText(String.valueOf(bundle.getInt("e_year")));
            edit_sport_input.setText(String.valueOf(bundle.getInt("sid")));
            edit_tid_input.setText(String.valueOf(bundle.getInt("id")));

            edit_tid_input.setEnabled(false);
        }

        edit_save_changes_button_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeamManageData.updateTeam(
                        Integer.valueOf(edit_tid_input.getText().toString()),
                        edit_name_input.getText().toString(),
                        edit_stadium_name_input.getText().toString(),
                        edit_city_input.getText().toString(),
                        edit_country_input.getText().toString(),
                        Integer.valueOf(edit_sport_input.getText().toString()),
                        Integer.valueOf(edit_birth_year_input.getText().toString()),
                        bundle.getDouble("lat"),
                        bundle.getDouble("lng"),
                        getActivity()
                );

                Toast.makeText(getActivity(),"Team Updated!",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        getActivity().setTitle("Edit Team");
    }
}