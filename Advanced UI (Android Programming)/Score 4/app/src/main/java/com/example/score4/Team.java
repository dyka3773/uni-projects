package com.example.score4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Team extends Fragment {

    private TextView teamName;
    private TextView stadiumName;
    private TextView city;
    private TextView country;
    private TextView sid;
    private TextView e_year;
    private TextView lat;
    private TextView lng;
    private MapView map_view;

    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.team_fragment, container, false);


        teamName = view.findViewById(R.id.team_name);
        stadiumName = view.findViewById(R.id.stadium_var);
        city = view.findViewById(R.id.city_var);
        country = view.findViewById(R.id.country_var);
        sid = view.findViewById(R.id.sport_var);
        e_year = view.findViewById(R.id.birthday_var);
        lat = view.findViewById(R.id.team_lat);
        lng = view.findViewById(R.id.team_lng);
        map_view = view.findViewById(R.id.mapView2);

        Bundle bundle = this.getArguments();

        if (bundle== null){
            Toast.makeText(getActivity(),"Something went wrong",Toast.LENGTH_SHORT).show();
        }
        else{


            teamName.setText(bundle.getString("teamName"));
            stadiumName.setText(bundle.getString("stadiumName"));
            city.setText(bundle.getString("city"));
            country.setText(bundle.getString("country"));
            sid.setText(String.valueOf((bundle.getInt("sid"))));
            e_year.setText(String.valueOf((bundle.getInt("e_year"))));
            lat.setText(String.valueOf(bundle.getDouble("lat")));
            lng.setText(String.valueOf(bundle.getDouble("lng")));

            LatLng team_country = new LatLng(bundle.getDouble("lat"),bundle.getDouble("lng"));

            map_view.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap myGoogleMap) {
                    googleMap = myGoogleMap;

                    googleMap.addMarker(new MarkerOptions().position(team_country).title((String)teamName.getText()));

                    CameraPosition cameraPosition = new CameraPosition.Builder().target(team_country).zoom(12).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
            });

        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        getActivity().setTitle("Team");
    }
}