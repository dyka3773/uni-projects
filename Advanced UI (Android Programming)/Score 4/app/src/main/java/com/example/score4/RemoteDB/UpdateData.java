package com.example.score4.RemoteDB;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.score4.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class UpdateData {

    // To FragmentAcivity antikeimeno stis methodous einai gia na mporei na doulepsei to Toast kateuthian apo thn methodo.
    // To addOnCompleteListener trexei se diaforetiko thread apo to main thread.
    public static void getAllDocumentIds(ArrayList idList, String collectionName) {
        idList.clear();
        MainActivity.db.collection(collectionName).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        idList.add(document.getId());
                        Log.d(TAG, document.getId() + " => " + document.getData());
                    }
                } else {
                    Log.w(TAG, "Error getting documents.", task.getException());
                }
            }
            });
    }

    public static void updateSportData(String collectionName, String documentID, String fieldName, Object value, FragmentActivity activity) {
        MainActivity.db.collection(collectionName).document(documentID).update(fieldName, value)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(activity, collectionName + " data updated successfully!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    /*
    public static void updateBasketballData(String documentID, String fieldName, Object value, FragmentActivity activity) {
        MainActivity.db.collection("Basketball").document(documentID).update(fieldName, value)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "updateBasketballData DocumentSnapshot successfully updated!");
                        Toast.makeText(activity, "Basketball data updated successfully!", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "updateBasketballData Error updating document", e);
                        Toast.makeText(activity, "Basketball data update failed.", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public static void updateBoxingData(String documentID, String fieldName, Object value, FragmentActivity activity) {
        MainActivity.db.collection("Boxing").document(documentID).update(fieldName, value)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "updateBoxingData DocumentSnapshot successfully updated!");
                        Toast.makeText(activity, "Boxing data updated successfully!", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "updateBoxingData Error updating document", e);
                        Toast.makeText(activity, "Boxing data update failed.", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public static void updateFootballData(String documentID, String fieldName, Object value, FragmentActivity activity) {
        MainActivity.db.collection("Football").document(documentID).update(fieldName, value)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "updateFootballData DocumentSnapshot successfully updated!");
                        Toast.makeText(activity, "Football data updated successfully!", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "updateFootballData Error updating document", e);
                        Toast.makeText(activity, "Football data update failed.", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public static void updateVolleyballData(String documentID, String fieldName, Object value, FragmentActivity activity) {
        MainActivity.db.collection("Volleyball").document(documentID).update(fieldName, value)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "updateVolleyballData DocumentSnapshot successfully updated!");
                        Toast.makeText(activity, "Football data updated successfully!", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "updateVolleyballData Error updating document", e);
                        Toast.makeText(activity, "Volleyball data update failed.", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public static void updateWrestlingData(String documentID, String fieldName, Object value, FragmentActivity activity) {
        MainActivity.db.collection("Wrestling").document(documentID).update(fieldName, value)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "updateWrestlingData DocumentSnapshot successfully updated!");
                        Toast.makeText(activity, "Wrestling data updated successfully!", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "updateWrestlingData Error updating document", e);
                        Toast.makeText(activity, "Wrestling data update failed.", Toast.LENGTH_LONG).show();
                    }
                });
    }
     */
}
