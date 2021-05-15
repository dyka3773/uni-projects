package com.example.score4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.score4.LocalDB.TeamDB;

import java.util.List;

import static com.example.score4.MainActivity.localDB;

public class Team_Selection extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.team_selection_fragment, container, false);

        List<TeamDB> team_items = localDB.localDao().getTeamDB();

        for ( TeamDB team: team_items ) {
            int id = team.getTID();
            String teamName = team.getTeamName();
            String stadiumName = team.getS_name();
            String city = team.getCity();
            String country = team.getCountry();
            int sid = team.getSID();
            int e_year = team.getE_year();
            double lat = team.getLatitude();
            double lng = team.getLongtitude();

//            Toast.makeText(getActivity(),teamName+" "+lastName,Toast.LENGTH_SHORT).show();

            View view1 = inflater.inflate(R.layout.fragment_db_item, container);

            TextView textView = view1.findViewById(R.id.item_name);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("teamName", teamName);
                    bundle.putInt("id", id);
                    bundle.putString("stadiumName", stadiumName);
                    bundle.putString("city", city);
                    bundle.putString("country", country);
                    bundle.putInt("sid", sid);
                    bundle.putInt("e_year", e_year);
                    bundle.putDouble("lat", lat);
                    bundle.putDouble("lng", lng);


                    Team frag = new Team();
                    frag.setArguments(bundle);

                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.container, frag);
                    ft.addToBackStack(null);
                    ft.commit();
                }
            });

            ImageView editButton = view1.findViewById(R.id.edit_button);

            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),teamName,Toast.LENGTH_SHORT).show();
                    // TODO edit
                }
            });

            ImageView deleteButton = view1.findViewById(R.id.delete_button);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    localDB.localDao().deleteTeamLocal(team);  // Refresh list

                    Toast.makeText(getActivity(),"Team Deleted!",Toast.LENGTH_SHORT).show();
                }
            });

            Bundle bundle1 = new Bundle();
            bundle1.putString("Name",teamName);

            db_item db_item= new db_item();
            db_item.setArguments(bundle1);

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.tableLayout3, db_item);
            fragmentTransaction.commit();
        }



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Team Selection");
    }
}