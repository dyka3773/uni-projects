package com.example.score4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class db_item extends Fragment {

    ImageView edit;
    ImageView delete;
    View.OnClickListener click1;
    View.OnClickListener click2;

    public db_item(){
    }

    public db_item( View.OnClickListener click1, View.OnClickListener click2) {
        this.click1 = click1;
        this.click2 = click2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_db_item, container, false);

        edit = view.findViewById(R.id.edit_button);
        edit.setOnClickListener(click1);

        delete = view.findViewById(R.id.delete_button);
        delete.setOnClickListener(click2);

        TextView textView = view.findViewById(R.id.item_name);

        Bundle bundle = this.getArguments();
        textView.setText(bundle.getString("Name"));

        return view;
    }
}