package com.example.score4.RemoteDB;

import java.util.HashMap;
import java.util.Map;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.score4.MainActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;

import static android.content.ContentValues.TAG;

public class InsertData {
    static Map<String, Object> data = new HashMap<>();

    public static void insertBasketballMatch(String city, String country, String date, int score_a,
                                             int score_b, int team_a, int team_b) {
        data.put("city", city);
        data.put("country", country);
        data.put("date", date);
        data.put("score_a", score_a);
        data.put("score_b", score_b);
        data.put("sport", "Basketball");
        data.put("team_a", team_a);
        data.put("team_b", team_b);

        MainActivity.db.collection("Basketball").document() //Dhmiourgei kainourgio document me tyxaio ID
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "insertBasketballMatch() DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "insertBasketballMatch() Error writing document", e);
                    }
                });

        data.clear();
    }

    public static void insertBoxingMatch(String city, String country, String date, int score_a,
                                         int score_b, int athlete_a, int athlete_b) {
        data.put("city", city);
        data.put("country", country);
        data.put("date", date);
        data.put("num_of_athletes", 2);
        data.put("athlete_a", athlete_a);
        data.put("score_a", score_a);
        data.put("athlete_b", athlete_b);
        data.put("score_b", score_b);

        MainActivity.db.collection("Boxing").document() //Dhmiourgei kainourgio document me tyxaio ID
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "insertBoxingMatch DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "insertBoxingMatch Error writing document", e);
                    }
                });

        data.clear();
    }

    public static void insertFootballMatch(String city, String country, String date, int score_a,
                                             int score_b, int team_a, int team_b) {
        data.put("city", city);
        data.put("country", country);
        data.put("date", date);
        data.put("score_a", score_a);
        data.put("score_b", score_b);
        data.put("sport", "Football");
        data.put("team_a", team_a);
        data.put("team_b", team_b);

        MainActivity.db.collection("Football").document() //Dhmiourgei kainourgio document me tyxaio ID
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "insertFootballMatch DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "insertFootballMatch Error writing document", e);
                    }
                });

        data.clear();
    }

    public static void insertVolleyballMatch(String city, String country, String date, int score_a,
                                             int score_b, int team_a, int team_b){
        data.put("city", city);
        data.put("country", country);
        data.put("date", date);
        data.put("score_a", score_a);
        data.put("score_b", score_b);
        data.put("sport", "Volleyball");
        data.put("team_a", team_a);
        data.put("team_b", team_b);

        MainActivity.db.collection("Volleyball").document() //Dhmiourgei kainourgio document me tyxaio ID
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "insertVolleyballMatch DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "insertVolleyballMatch Error writing document", e);
                    }
                });

        data.clear();
    }

    public static void insertWrestlingMatch(String city, String country, String date, int score_a,
                                         int score_b, int athlete_a, int athlete_b){
        data.put("city", city);
        data.put("country", country);
        data.put("date", date);
        data.put("num_of_athletes", 2);
        data.put("athlete_a", athlete_a);
        data.put("score_a", score_a);
        data.put("athlete_b", athlete_b);
        data.put("score_b", score_b);

        MainActivity.db.collection("Wrestling").document() //Dhmiourgei kainourgio document me tyxaio ID
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "insertWrestlingMatch DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "insertWrestlingMatch Error writing document", e);
                    }
                });

        data.clear();
    }
}