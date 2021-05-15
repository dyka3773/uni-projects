package com.example.score4.LocalDB;

import android.content.Context;
import android.widget.Toast;

import com.example.score4.Athlete;
import com.example.score4.MainActivity;
import com.example.score4.Team;

public class FillDB {
    public static void filldb(Context context) {
        try {
            SportDB sportDB = new SportDB(35, "Football", "Team", "Male");
            MainActivity.localDB.localDao().insertSportLocal(sportDB);

            sportDB = new SportDB(36, "Basketball", "Team", "Female");
            MainActivity.localDB.localDao().insertSportLocal(sportDB);

            sportDB = new SportDB(37, "Volleyball", "Team", "Female");
            MainActivity.localDB.localDao().insertSportLocal(sportDB);

            sportDB = new SportDB(38, "Boxing", "Singles", "Male");
            MainActivity.localDB.localDao().insertSportLocal(sportDB);

            sportDB = new SportDB(39, "Wrestling", "Singles", "Male");
            MainActivity.localDB.localDao().insertSportLocal(sportDB);
            sportDB = null;

            AthleteDB athleteDB = new AthleteDB(319, "Δημοσθένης", "Γκαΐζος", "Ελασσόνα", "Ελλάδα", 38, 1993, 39.894312, 22.189275);
            MainActivity.localDB.localDao().insertAthleteLocal(athleteDB);

            athleteDB = new AthleteDB(326, "Carl", "Johnson", "Los Santos", "USA", 38, 2004, 40.109036, -1.284313);
            MainActivity.localDB.localDao().insertAthleteLocal(athleteDB);

            athleteDB = new AthleteDB(332, "Ντένης", "Τρομερόπουλος", "Ζαγκλιβέρι", "Ελλάδα", 38, 1993, 40.574996, 23.292800);
            MainActivity.localDB.localDao().insertAthleteLocal(athleteDB);

            athleteDB = new AthleteDB(345, "Ηρακλής", "Κόνσουλας", "Περαία", "Ελλάδα", 39, 2000, 40.505657, 22.927510);
            MainActivity.localDB.localDao().insertAthleteLocal(athleteDB);

            athleteDB = new AthleteDB(300, "Λεωνίδας", "Σπάρτης", "Σπάρτη", "Ελλάδα", 39, 480, 37.073586, 22.428736);
            MainActivity.localDB.localDao().insertAthleteLocal(athleteDB);
            athleteDB = null;

            TeamDB teamDB = new TeamDB(9850, "Αστέρας Ραχούλας", "Ραγήπεδο", "Βουλιαγμένη", "Ελλάδα", 35, 2017, 37.809395, 23.774761);
            MainActivity.localDB.localDao().insertTeamLocal(teamDB);

            teamDB = new TeamDB(9800, "Ολυβγείτεξω", "Περαίας", "Αθήνα", "Ελλάδα", 35, 2009, 37.946433, 23.664459);
            MainActivity.localDB.localDao().insertTeamLocal(teamDB);

            teamDB = new TeamDB(9835, "Καραδήμου United", "Ζιάρου Stadium", "Καβάλα", "Ελλάδα", 36, 2014, 40.942240, 24.405346);
            MainActivity.localDB.localDao().insertTeamLocal(teamDB);

            teamDB = new TeamDB(9810, "Σουταρτζίδες", "Σουτέρ", "Σουλτογιανναίικα", "Ελλάδα", 36, 2010, 41.087091, 22.675755);
            MainActivity.localDB.localDao().insertTeamLocal(teamDB);

            teamDB = new TeamDB(9813, "Μπαλάδ-όχι", "Γήπεδο", "Ικαρία", "Ελλάδα", 37, 2000, 37.601126, 26.080972);
            MainActivity.localDB.localDao().insertTeamLocal(teamDB);

            teamDB = new TeamDB(9856, "Σουρεάλ Μαδρίτης", "Ανατολίτης", "Θεσσαλονίκη", "Ελλάδα", 37, 2015, 40.615914, 22.97020);
            MainActivity.localDB.localDao().insertTeamLocal(teamDB);
            teamDB = null;
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }


    }
}
