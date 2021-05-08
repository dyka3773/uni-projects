package com.example.score4.LocalDB;

import android.util.Log;

import com.example.score4.MainActivity;
import static android.content.ContentValues.TAG;


public class TeamManageData {
    public static void insertTeam(int tid, String teamName, String s_name, String city, String country, int SID, int e_year, double hometown) {
        try {
            TeamDB team = new TeamDB(tid, teamName, s_name, city, country, SID, e_year, hometown);
            MainActivity.localDB.dao().insertTeamLocal(team);
            Log.d(TAG, "Team " + tid + " added successfully.");
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public static void updateTeam(int tid, String teamName, String s_name, String city, String country, int SID, int e_year, double hometown) {
        try {
            TeamDB team = new TeamDB(tid, teamName, s_name, city, country, SID, e_year, hometown);
            MainActivity.localDB.dao().updateTeamLocal(team);
            Log.d(TAG, "Team " + tid + " updated successfully.");
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public static void deleteTeam(int tid) {
        try {
            TeamDB team = new TeamDB();
            team.setTID(tid);
            MainActivity.localDB.dao().deleteTeamLocal(team);
            Log.d(TAG, "Team " + tid + " deleted successfully.");
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }
}