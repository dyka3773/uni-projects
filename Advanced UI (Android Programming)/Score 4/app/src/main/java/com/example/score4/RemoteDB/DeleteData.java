package com.example.score4.RemoteDB;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.score4.LocalDB.SendNotification;
import com.example.score4.MainActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class DeleteData {
    public static void deleteSportData(String collectionName, String documentID, FragmentActivity activity) {
        MainActivity.db.collection(collectionName).document(documentID).delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        SendNotification.getNotification(activity, "Success!", "Match " + documentID + " has been deleted.");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
