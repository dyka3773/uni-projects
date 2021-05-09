package com.example.score4.LocalDB;

import com.example.score4.MainActivity;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

public class AthleteManageData {
    public static void insertAthlete(int AID, String f_name, String l_name, String city, String country, int SID,
                                     int b_year, double hometown, FragmentActivity activity) {
        try {
            AthleteDB athlete = new AthleteDB(AID, f_name, l_name, city, country, SID, b_year, hometown);
            MainActivity.localDB.dao().insertAthleteLocal(athlete);
            Toast.makeText(activity, "Athlete data inserted successfully!", Toast.LENGTH_SHORT);
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG);
        }
    }

    public static void updateAthlete(int AID, String f_name, String l_name, String city, String country, int SID,
                                     int b_year, double hometown, FragmentActivity activity) {
        try {
            AthleteDB athlete = new AthleteDB(AID, f_name, l_name, city, country, SID, b_year, hometown);
            MainActivity.localDB.dao().updateAthleteLocal(athlete);
            Toast.makeText(activity, "Athlete data updated successfully!", Toast.LENGTH_SHORT);
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG);
        }
    }

    public static void deleteAthlete(int AID, FragmentActivity activity) {
        try {
            AthleteDB athlete = new AthleteDB();
            MainActivity.localDB.dao().deleteAthleteLocal(athlete);
            Toast.makeText(activity, "Athlete data deleted successfully!", Toast.LENGTH_SHORT);
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG);
        }
    }
}