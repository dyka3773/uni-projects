package com.example.score4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class db_item extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_db_item, container, false);

        TextView textView = view.findViewById(R.id.item_name);

        Bundle bundle = this.getArguments();
        textView.setText(bundle.getString("Name"));

        return view;
    }
}