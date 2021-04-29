package com.example.score4.RemoteDB;

import java.util.HashMap;
import java.util.Map;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.score4.MainActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import static android.content.ContentValues.TAG;

public class InsertData {
    static Map<String, Object> data = new HashMap<>();

    public static void insertBasketballMatch(String city, String country, String date, int score_a,
                                             int score_b, int team_a, int team_b, String documentID){
        data.put("city", city);
        data.put("country", country);
        data.put("date", date);
        data.put("score_a", score_a);
        data.put("score_b", score_b);
        data.put("sport", "Basketball");
        data.put("team_a", team_a);
        data.put("teab_b", team_b);

        MainActivity.db.collection("Basketball").document(documentID)
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });

        data.clear();
    }
/*
    public static void insertBoxingMatch(String city, String country, String date, int score_a,
                                         int score_b, int AID_a, int AID_b, String documentID){
        data.put("city", city);
        data.put("country", country);
        data.put("date", date);
        data.put("num_of_athletes", 2);
        data.put("Athletes/" + AID_a, ) // edw tha prepei na balw deutero map
    }
 */
    public static void insertFootballMatch(String city, String country, String date, int score_a,
                                             int score_b, int team_a, int team_b, String documentID){
        data.put("city", city);
        data.put("country", country);
        data.put("date", date);
        data.put("score_a", score_a);
        data.put("score_b", score_b);
        data.put("sport", "Football");
        data.put("team_a", team_a);
        data.put("teab_b", team_b);

        MainActivity.db.collection("Football").document(documentID)
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });

        data.clear();
    }

    public static void insertVolleyballMatch(String city, String country, String date, int score_a,
                                             int score_b, int team_a, int team_b, String documentID){
        data.put("city", city);
        data.put("country", country);
        data.put("date", date);
        data.put("score_a", score_a);
        data.put("score_b", score_b);
        data.put("sport", "Volleyball");
        data.put("team_a", team_a);
        data.put("teab_b", team_b);

        MainActivity.db.collection("Volleyball").document(documentID)
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });

        data.clear();
    }

    public static void insertWrestlingMatch(String city, String country, String date, int score_a,
                                         int score_b, int AID_a, int AID_b, String documentID){}
}
