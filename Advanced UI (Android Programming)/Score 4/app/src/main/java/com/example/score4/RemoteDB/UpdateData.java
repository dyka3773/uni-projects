package com.example.score4.RemoteDB;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.score4.MainActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import static android.content.ContentValues.TAG;

public class UpdateData {
    // Tha prepei na breis kapoion tropo gia na pairneis to documentID apo thn bash
    public static void updateBasketballData(String documentID, String fieldName, Object value) {
        MainActivity.db.collection("Basketball").document(documentID).update(fieldName, value)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "updateBasketballData DocumentSnapshot successfully updated!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "updateBasketballData Error updating document", e);
                    }
                });
    }

    public static void updateBoxingData(String documentID, String fieldName, Object value) {
        MainActivity.db.collection("Boxing").document(documentID).update(fieldName, value)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "updateBoxingData DocumentSnapshot successfully updated!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "updateBoxingData Error updating document", e);
                    }
                });
    }

    public static void updateFootballData(String documentID, String fieldName, Object value) {
        MainActivity.db.collection("Football").document(documentID).update(fieldName, value)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "updateFootballData DocumentSnapshot successfully updated!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "updateFootballData Error updating document", e);
                    }
                });
    }

    public static void updateVolleyballData(String documentID, String fieldName, Object value) {
        MainActivity.db.collection("Volleyball").document(documentID).update(fieldName, value)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "updateVolleyballData DocumentSnapshot successfully updated!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "updateVolleyballData Error updating document", e);
                    }
                });
    }

    public static void updateWrestlingData(String documentID, String fieldName, Object value) {
        MainActivity.db.collection("Wrestling").document(documentID).update(fieldName, value)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "updateWrestlingData DocumentSnapshot successfully updated!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "updateWrestlingData Error updating document", e);
                    }
                });
    }
}
