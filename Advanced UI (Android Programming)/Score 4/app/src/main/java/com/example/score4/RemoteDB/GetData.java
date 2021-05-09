package com.example.score4.RemoteDB;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.score4.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

import static android.content.ContentValues.TAG;

public class GetData {

    public static void getSportData(String collectionName, Map<String, Object> data, FragmentActivity activity) {
        MainActivity.db.collection(collectionName)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                data.put(document.getId(), document.getData());
                            }
                        } else {
                            Log.w(TAG, collectionName + " Error getting documents.", task.getException());
                            Toast.makeText(activity, "" + task.getException(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
/*
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
        MainActivity.db.collectionGroup("Athletes")
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
        });
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
 */
}
