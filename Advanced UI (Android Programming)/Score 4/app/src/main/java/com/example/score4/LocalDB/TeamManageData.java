package com.example.score4.LocalDB;

import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.score4.MainActivity;

public class TeamManageData {
    public static void insertTeam(int tid, String teamName, String s_name, String city, String country,
                                  int SID, int e_year, double latitude, double longtitude, FragmentActivity activity) {
        try {
            TeamDB team = new TeamDB(tid, teamName, s_name, city, country, SID, e_year, latitude, longtitude);
            MainActivity.localDB.localDao().insertTeamLocal(team);
            Toast.makeText(activity, "Team data inserted successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public static void updateTeam(int tid, String teamName, String s_name, String city, String country,
                                  int SID, int e_year, double latitude, double longtitude, FragmentActivity activity) {
        try {
            TeamDB team = new TeamDB(tid, teamName, s_name, city, country, SID, e_year, latitude,longtitude);
            MainActivity.localDB.localDao().updateTeamLocal(team);
            Toast.makeText(activity, "Team data updated successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public static void deleteTeam(int tid, FragmentActivity activity) {
        try {
            TeamDB team = new TeamDB();
            team.setTID(tid);
            MainActivity.localDB.localDao().deleteTeamLocal(team);
            Toast.makeText(activity, "Team data deleted successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}