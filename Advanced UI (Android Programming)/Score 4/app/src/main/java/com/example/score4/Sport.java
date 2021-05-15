package com.example.score4;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.score4.RemoteDB.DeleteData;
import com.example.score4.RemoteDB.UpdateData;

import java.util.ArrayList;
import java.util.Map;

import static android.content.ContentValues.TAG;
import static com.example.score4.MainActivity.localDB;

public class Sport extends Fragment {

    private TextView today;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.sport_fragment, container, false);

        Bundle bundle = this.getArguments();
        ArrayList<Map> matchList = new ArrayList();
        ArrayList<String> idList = new ArrayList();

        today = view.findViewById(R.id.today);

        if (bundle== null){
            Toast.makeText(getActivity(),"Something went wrong",Toast.LENGTH_SHORT).show();
        }
        else{
            today.setText(bundle.getString("SportIs") + " Matches");
            switch (bundle.getString("SportIs")){
                case "Volleyball":{
                    matchList = MainActivity.Volleyball;
                    idList = MainActivity.idListVolleyball;
//                    int backgroundColor = ContextCompat.getColor(getActivity(),R.color.volleyball);
//                    getActivity().getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#"+getActivity().getResources().getColor(R.color.volleyball))));
                    break;
                }
                case "Basketball":{
                    matchList = MainActivity.Basketball;
                    idList = MainActivity.idListBasketball;
//                    getActivity().getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#"+getActivity().getResources().getColor(R.color.basketball))));
                    break;
                }
                case "Wrestling":{
                    matchList = MainActivity.Wrestling;
                    idList = MainActivity.idListWrestling;
//                    getActivity().getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#"+getActivity().getResources().getColor(R.color.wrestling))));
                    break;
                }
                case "Football":{
                    matchList = MainActivity.Football;
                    idList = MainActivity.idListFootball;
//                    getActivity().getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#"+getActivity().getResources().getColor(R.color.football))));
                    break;
                }
                case "Boxing":{
                    matchList = MainActivity.Boxing;
                    idList = MainActivity.idListBoxing;
//                    getActivity().getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#"+getActivity().getResources().getColor(R.color.boxing))));
                    break;
                }
            }
        }

        int i;
//        for (Map<String,Object> match : matchList) {

        for(i=0;i<matchList.size();i++){
            Map<String,Object> match = matchList.get(i);
            final int j =i;
            final ArrayList<String> jdList = idList;

            View view1 = inflater.inflate(R.layout.fragment_db_item, container);

            View.OnClickListener click1 = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ( bundle.getString("SportIs").equals("Volleyball")||
                            bundle.getString("SportIs").equals("Football")||
                            bundle.getString("SportIs").equals("Basketball") ) {

                        Bundle bundle2= new Bundle();
                        bundle2.putString("SportIs", bundle.getString("SportIs"));
                        bundle2.putString("DocID",jdList.get(j));

                        bundle2.putString("team_a", match.get("team_a").toString());
                        bundle2.putString("team_b", match.get("team_b").toString());
                        bundle2.putString("score_a", match.get("score_a").toString());
                        bundle2.putString("score_b", match.get("score_b").toString());
                        bundle2.putString("city", match.get("city").toString());
                        bundle2.putString("country", match.get("country").toString());
                        bundle2.putString("date", match.get("date").toString());
                        bundle2.putString("sport", match.get("sport").toString());

                        EditTeamMatch frag  = new EditTeamMatch();
                        frag.setArguments(bundle2);

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.container, frag);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                    else {

                        Bundle bundle2 = new Bundle();
                        bundle2.putString("SportIs",bundle.getString("SportIs"));
                        bundle2.putString("DocID",jdList.get(j));

                        EditIndividualMatch frag = new EditIndividualMatch(match);
                        frag.setArguments(bundle2);

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.container, frag);
                        ft.addToBackStack(null);
                        ft.commit();
                    }

                }
            };


            View.OnClickListener click2 = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DeleteData.deleteSportData(bundle.getString("SportIs"), jdList.get(j) ,getActivity());

                    Toast.makeText(getActivity(),"Match Deleted!",Toast.LENGTH_SHORT).show();
                }
            };

            Bundle bundle1 = new Bundle();

            switch (bundle.getString("SportIs")){
                case "Volleyball":{
                    bundle1.putString("Name","Teams: " +match.get("team_a").toString()+" - "+ match.get("team_b")+"\nScore: "+match.get("score_a").toString()+" - "+ match.get("score_b"));
                    break;
                }
                case "Basketball":{
                    bundle1.putString("Name","Teams: " +match.get("team_a").toString()+" - "+ match.get("team_b")+"\nScore: "+match.get("score_a").toString()+" - "+ match.get("score_b"));
                    break;
                }
                case "Wrestling":{
                    bundle1.putString("Name","Athletes: "+ match.get("athlete_a").toString()+" - "+ match.get("athlete_b")+"\nScore: "+match.get("score_a").toString()+" - "+ match.get("score_b"));
                    break;
                }
                case "Football":{
                    bundle1.putString("Name","Teams: " +match.get("team_a").toString()+" - "+ match.get("team_b")+"\nScore: "+match.get("score_a").toString()+" - "+ match.get("score_b"));
                    break;
                }
                case "Boxing":{
                    bundle1.putString("Name","Athletes: "+ match.get("athlete_a").toString()+" - "+ match.get("athlete_b")+"\nScore: "+match.get("score_a").toString()+" - "+ match.get("score_b"));
                    break;
                }
            }

            db_item db_item= new db_item(click1,click2);
            db_item.setArguments(bundle1);

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragmentContainerView, db_item);
            fragmentTransaction.commit();

            Log.d(TAG,match.toString());
        }


        return view;
    }

    // TODO ADD COLOR ACCORDING TO SPORT
}