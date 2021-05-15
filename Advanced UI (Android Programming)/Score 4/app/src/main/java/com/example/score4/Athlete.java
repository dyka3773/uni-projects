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

public class Athlete extends Fragment {

    private TextView athlete_name;
    private TextView city_var;
    private TextView country_var;
    private TextView sport_var;
    private TextView birthday_var;
    private TextView latitude;
    private TextView longitude;
    private MapView map_view;

    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.athlete_fragment, container, false);

        athlete_name = view.findViewById(R.id.athlete_name);
        city_var = view.findViewById(R.id.city_var);
        country_var = view.findViewById(R.id.country_var);
        sport_var = view.findViewById(R.id.sport_var);
        birthday_var = view.findViewById(R.id.birthday_var);
        latitude = view.findViewById(R.id.latitude);
        longitude = view.findViewById(R.id.longitude);
        map_view = view.findViewById(R.id.map_view);

        Bundle bundle = this.getArguments();

        if (bundle== null){
            Toast.makeText(getActivity(),"Something went wrong",Toast.LENGTH_SHORT).show();
        }
        else{
            athlete_name.setText(bundle.getString("firstName")+" "+bundle.getString("lastName"));
            city_var.setText(bundle.getString("city"));
            country_var.setText(bundle.getString("country"));
            sport_var.setText(String.valueOf(bundle.getInt("sid")));
            birthday_var.setText(String.valueOf(bundle.getInt("birth")));
            latitude.setText(String.valueOf(bundle.getDouble("lat")));
            longitude.setText(String.valueOf(bundle.getDouble("lng")));

            LatLng athlete_country = new LatLng(bundle.getDouble("lat"),bundle.getDouble("lng"));

            map_view.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap myGoogleMap) {
                    googleMap = myGoogleMap;

                    googleMap.addMarker(new MarkerOptions().position(athlete_country).title((String)athlete_name.getText()));

                    CameraPosition cameraPosition = new CameraPosition.Builder().target(athlete_country).zoom(12).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
            });

        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Athlete");
    }
}