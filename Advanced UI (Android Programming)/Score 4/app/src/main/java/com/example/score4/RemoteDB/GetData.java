package com.example.score4.RemoteDB;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.score4.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogRecord;

import static android.content.ContentValues.TAG;

public class GetData {
    public static void getSportData(String collectionName, ArrayList<Map> data, Context context, FragmentActivity activity) {
        data.clear();
        MainActivity.db.collection(collectionName)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                data.add(document.getData());
                            }
                        } else {
                            Log.w(TAG, collectionName + " Error getting documents.", task.getException());
                            Toast.makeText(activity, "" + task.getException(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
