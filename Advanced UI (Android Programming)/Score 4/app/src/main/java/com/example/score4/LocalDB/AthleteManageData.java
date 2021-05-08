package com.example.score4.LocalDB;

import com.example.score4.Athlete;
import com.example.score4.MainActivity;
import android.util.Log;
import static android.content.ContentValues.TAG;

public class AthleteManageData {
    public static void insertAthlete(int AID, String f_name, String l_name, String city, String country, int SID, int b_year, double hometown) {
        try {
            AthleteDB athlete = new AthleteDB(AID, f_name, l_name, city, country, SID, b_year, hometown);
            MainActivity.localDB.dao().insertAthleteLocal(athlete);
            Log.d(TAG, "Athlete " + AID + " added successfully.");
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public static void updateAthlete(int AID, String f_name, String l_name, String city, String country, int SID, int b_year, double hometown) {
        try {
            AthleteDB athlete = new AthleteDB(AID, f_name, l_name, city, country, SID, b_year, hometown);
            MainActivity.localDB.dao().updateAthleteLocal(athlete);
            Log.d(TAG, "Athlete " + AID + " updated successfully.");
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public static void deleteAthlete(int AID) {
        try {
            AthleteDB athlete = new AthleteDB();
            MainActivity.localDB.dao().deleteAthleteLocal(athlete);
            Log.d(TAG, "Athlete " + AID + " deleted successfully.");
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }
}