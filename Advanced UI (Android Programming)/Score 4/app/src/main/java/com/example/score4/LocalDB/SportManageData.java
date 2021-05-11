package com.example.score4.LocalDB;

import com.example.score4.MainActivity;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

public class SportManageData {
    public static void insertSport(int sportID, String sportName, String sportType, String gender, FragmentActivity activity) {
        try {
            SportDB sport = new SportDB(sportID, sportName, sportType, gender);
            MainActivity.localDB.localDao().insertSportLocal(sport);
            Toast.makeText(activity, "Sport data inserted successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    // An afiseis kapoio pedio enos antikeimenou sport ws null tote automata tha perastei to null sthn bash.
    public static void updateSport(int sportID, String sportName, String sportType, String gender, FragmentActivity activity) {
        try {
            SportDB sport = new SportDB(sportID, sportName, sportType, gender);
            MainActivity.localDB.localDao().updateSportLocal(sport);
            Toast.makeText(activity, "Sport data updated successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public static void deleteSport(int sportID, FragmentActivity activity) {
        try {
            SportDB sport = new SportDB();
            sport.setSportID(sportID);
            MainActivity.localDB.localDao().deleteSportLocal(sport);
            Toast.makeText(activity, "Sport data deleted successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
