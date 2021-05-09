package com.example.score4.LocalDB;

import com.example.score4.MainActivity;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

public class SportManageData {
    public static void insertSport(int sportID, String sportName, String sportType, String gender, FragmentActivity activity) {
        try {
            SportDB sport = new SportDB(sportID, sportName, sportType, gender);
            MainActivity.localDB.dao().insertSportLocal(sport);
            Toast.makeText(activity, "Sport data inserted successfully!", Toast.LENGTH_SHORT);
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG);
        }
    }

    public static void updateSport(int sportID, String sportName, String sportType, String gender, FragmentActivity activity) {
        try {
            SportDB sport = new SportDB(sportID, sportName, sportType, gender);
            MainActivity.localDB.dao().updateSportLocal(sport);
            Toast.makeText(activity, "Sport data updated successfully!", Toast.LENGTH_SHORT);
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG);
        }
    }

    public static void deleteSport(int sportID, FragmentActivity activity) {
        try {
            SportDB sport = new SportDB();
            sport.setSportID(sportID);
            MainActivity.localDB.dao().deleteSportLocal(sport);
            Toast.makeText(activity, "Sport data deleted successfully!", Toast.LENGTH_SHORT);
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG);
        }
    }
}
