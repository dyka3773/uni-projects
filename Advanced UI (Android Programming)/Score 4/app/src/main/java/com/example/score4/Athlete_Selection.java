package com.example.score4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.score4.LocalDB.AthleteDB;
import com.example.score4.LocalDB.AthleteManageData;
import com.example.score4.LocalDB.SportManageData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static com.example.score4.MainActivity.localDB;


public class Athlete_Selection extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.athlete_selection_fragment, container, false);

        SportManageData.insertSport(52, "pleb", "Team", "Male",getActivity());
        AthleteManageData.insertAthlete(69,"dfgfgd","sfdfsfds","sdfsdf","fsdfsf",52,6,354,54,getActivity());
        AthleteManageData.insertAthlete(9,"dffdgfgd","sfddfgfsfds","sdfsdfgdf","fsddgfsf",52,60,3454,514,getActivity());
        List<AthleteDB> athlete_items = localDB.localDao().getAthleteDB();

        for ( AthleteDB athlete: athlete_items ) {
            int id = athlete.getAID();
            String firstName = athlete.getF_name();
            String lastName = athlete.getL_name();
            String city = athlete.getCity();
            String country = athlete.getCountry();
            int sid = athlete.getSID();
            int birth = athlete.getB_year();
            double lat = athlete.getLatitude();
            double lng = athlete.getLongtitude();

            Toast.makeText(getActivity(),firstName+" "+lastName,Toast.LENGTH_SHORT).show();

            View view1 = inflater.inflate(R.layout.fragment_db_item, container);

            TextView textView = view1.findViewById(R.id.item_name);
            textView.setText(firstName+" "+lastName);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("firstName", firstName);
                    bundle.putInt("id", id);
                    bundle.putString("lastName", lastName);
                    bundle.putString("city", city);
                    bundle.putString("country", country);
                    bundle.putInt("sid", sid);
                    bundle.putInt("birth", birth);
                    bundle.putDouble("lat", lat);
                    bundle.putDouble("lng", lng);


                    Athlete frag = new Athlete();

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
                    Toast.makeText(getActivity(),firstName+" "+lastName,Toast.LENGTH_SHORT).show();
                }
            });

            ImageView deleteButton = view1.findViewById(R.id.delete_button);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    localDB.localDao().deleteAthleteLocal(athlete);  // Refresh list

                    Toast.makeText(getActivity(),firstName+" "+lastName,Toast.LENGTH_SHORT).show();
                }
            });

            db_item db_item= new db_item();

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.tableLayout4, db_item);
            fragmentTransaction.commit();
        }


        return view;
    }
}