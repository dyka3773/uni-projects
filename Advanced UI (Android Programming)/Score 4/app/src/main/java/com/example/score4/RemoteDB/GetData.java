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

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class GetData {
    public static void getSportData(String collectionName, Map<String, Object> data, FragmentActivity activity) {
        data.clear();
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
}
