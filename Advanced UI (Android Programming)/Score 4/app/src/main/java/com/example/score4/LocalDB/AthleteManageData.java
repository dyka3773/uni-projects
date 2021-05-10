package com.example.score4.LocalDB;

import com.example.score4.MainActivity;

import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import static android.content.ContentValues.TAG;

// Gia kapoion logo ta MainActivity.localDB.dao().kapoia_methodos() bgazoyn attempt to invoke virtual method on null object reference.
public class AthleteManageData {
    public static void insertAthlete(int AID, String f_name, String l_name, String city, String country, int SID,
                                     int b_year, double hometown, FragmentActivity activity) {
        try {
            AthleteDB athlete = new AthleteDB(AID, f_name, l_name, city, country, SID, b_year, hometown);
            Log.d(TAG, "AID: " + athlete.getAID() + " f_name: " + athlete.getF_name()
                    + " l_name: " + athlete.getL_name() + " city: " + athlete.getCity() + " country: " + athlete.getCountry()
                    + " SID: " + athlete.getSID() + " b_year: " + athlete.getB_year() + " hometown:" + athlete.getHometown());
            MainActivity.localDB.localDao().insertAthleteLocal(athlete);
            Toast.makeText(activity, "Athlete data inserted successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public static void updateAthlete(int AID, String f_name, String l_name, String city, String country, int SID,
                                     int b_year, double hometown, FragmentActivity activity) {
        try {
            AthleteDB athlete = new AthleteDB(AID, f_name, l_name, city, country, SID, b_year, hometown);
            MainActivity.localDB.localDao().updateAthleteLocal(athlete);
            Toast.makeText(activity, "Athlete data updated successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public static void deleteAthlete(int AID, FragmentActivity activity) {
        try {
            AthleteDB athlete = new AthleteDB();
            athlete.setAID(AID);
            MainActivity.localDB.localDao().deleteAthleteLocal(athlete);
            Toast.makeText(activity, "Athlete data deleted successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}