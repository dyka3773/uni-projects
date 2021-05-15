package com.example.score4.LocalDB;

import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.score4.MainActivity;

@Database(entities = {AthleteDB.class, SportDB.class, TeamDB.class}, version = 4)
public abstract class LocalDatabase extends RoomDatabase {
    public abstract LocalDAO localDao();
    public static void wipeDBTables(FragmentActivity activity) {
        try {
            MainActivity.localDB.localDao().deleteAllAthlete();
            MainActivity.localDB.localDao().deleteAllTeam();
            MainActivity.localDB.localDao().deleteAllSport();
            Toast.makeText(activity, "DB wiped successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}