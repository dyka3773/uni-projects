package com.example.score4.RemoteDB;

import java.util.HashMap;
import java.util.Map;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.score4.LocalDB.SendNotification;
import com.example.score4.MainActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class InsertData {
    static Map<String, Object> data = new HashMap<>();

    public static void insertTeamSportMatch(String collectionName, String city, String country, String date, int score_a,
                                            int score_b, int team_a, int team_b, FragmentActivity activity) {
        data.put("city", city);
        data.put("country", country);
        data.put("date", date);
        data.put("score_a", score_a);
        data.put("score_b", score_b);
        data.put("sport", collectionName);
        data.put("team_a", team_a);
        data.put("team_b", team_b);

        MainActivity.db.collection(collectionName).document() //Dhmiourgei kainourgio document me tyxaio ID
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        SendNotification.getNotification(activity, "Success!", "Match has been inserted.");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        data.clear();
    }

    public static void insertSinglesSportMatch(String collectionName, String city, String country, String date, int score_a,
                                               int score_b, int athlete_a, int athlete_b, FragmentActivity activity) {
        data.put("city", city);
        data.put("country", country);
        data.put("date", date);
        data.put("num_of_athletes", 2);
        data.put("athlete_a", athlete_a);
        data.put("score_a", score_a);
        data.put("athlete_b", athlete_b);
        data.put("score_b", score_b);

        MainActivity.db.collection(collectionName).document() //Dhmiourgei kainourgio document me tyxaio ID
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        SendNotification.getNotification(activity, "Success!", "Match has been inserted.");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        data.clear();
    }
}