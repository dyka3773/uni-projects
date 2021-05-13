package com.example.score4.LocalDB;

import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {AthleteDB.class, SportDB.class, TeamDB.class}, version = 4)
public abstract class LocalDatabase extends RoomDatabase {
    public abstract LocalDAO localDao();
    public void wipeDBTables(FragmentActivity activity) {
        try {
            localDao().deleteAllAthlete();
            localDao().deleteAllTeam();
            localDao().deleteAllSport();
            Toast.makeText(activity, "DB wiped successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}