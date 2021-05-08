package com.example.score4.LocalDB;

import com.example.score4.MainActivity;
import android.util.Log;
import static android.content.ContentValues.TAG;

public class SportManageData {
    public static void insertSport(int sportID, String sportName, String sportType, String gender) {
        try {
            SportDB sport = new SportDB(sportID, sportName, sportType, gender);
            MainActivity.localDB.dao().insertSportLocal(sport);
            Log.d(TAG, "Sport " + sportID + " added successfully.");
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public static void updateSport(int sportID, String sportName, String sportType, String gender) {
        try {
            SportDB sport = new SportDB(sportID, sportName, sportType, gender);
            MainActivity.localDB.dao().updateSportLocal(sport);
            Log.d(TAG, "Sport" + sportID + " updated successfully.");
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public static void deleteSport(int sportID) {
        try {
            SportDB sport = new SportDB();
            sport.setSportID(sportID);
            MainActivity.localDB.dao().deleteSportLocal(sport);
            Log.d(TAG, "Sport" + sportID + " deleted successfully.");
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }
}
