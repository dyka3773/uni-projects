package com.example.score4.RemoteDB;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.score4.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Collections;

import static android.content.ContentValues.TAG;

public class GetData {
    public static void getBasketballMatch(){
        MainActivity.db.collection("Basketball")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Basketball");
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "getBasketballMatch Error getting documents.", task.getException());
                        }
                    }
                });
    }

    // to collectionGroup bgazei apotelesmata kai apo to wrestling gia thn wra
    public static void getBoxingMatch(){
        MainActivity.db.collection("Boxing")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Boxing");
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "getBoxingMatch Error getting documents.", task.getException());
                        }
                    }
                });
        /*MainActivity.db.collectionGroup("Athletes")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Log.d(TAG, document.getId() + " => " + document.getData());
                        }
                    } else {
                        Log.w(TAG, "getBoxingMatch Error getting documents.", task.getException());
                    }
                }
        });*/
    }

    public static void getFootballMatch(){
        MainActivity.db.collection("Football")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Football");
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "getFootballMatch Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public static void getVolleyballMatch(){
        MainActivity.db.collection("Volleyball")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Volleyball");
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "getVolleyballMatch Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public static void getWrestlingMatch(){
        MainActivity.db.collection("Wrestling")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Wrestling");
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "getWrestlingMatch Error getting documents.", task.getException());
                        }
                    }
                });
    }
}
