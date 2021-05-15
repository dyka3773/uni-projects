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

import com.example.score4.LocalDB.AthleteDB;

import java.util.List;

import static com.example.score4.MainActivity.localDB;

public class Athlete_Selection extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.athlete_selection_fragment, container, false);

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

            // Toast.makeText(getActivity(),firstName+" "+lastName,Toast.LENGTH_SHORT).show();

            View view1 = inflater.inflate(R.layout.fragment_db_item, container);

            TextView textView = view1.findViewById(R.id.item_name);

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
                    Toast.makeText(getActivity(),firstName+" "+lastName,Toast.LENGTH_SHORT).show();
                    // TODO edit
                }
            });

            ImageView deleteButton = view1.findViewById(R.id.delete_button);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    localDB.localDao().deleteAthleteLocal(athlete);  // Refresh list

                    Toast.makeText(getActivity(),"Athlete Deleted!",Toast.LENGTH_SHORT).show();
                }
            });

            Bundle bundle1 = new Bundle();
            bundle1.putString("Name",firstName+" "+lastName);

            db_item db_item= new db_item();
            db_item.setArguments(bundle1);

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.tableLayout4, db_item);
            fragmentTransaction.commit();
        }


        return view;
    }
}