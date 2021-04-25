package com.example.score4.LocalDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface DAO {
    @Query("SELECT * FROM athlete")
    public List<AthleteDB> getAthleteDB();

    @Query("SELECT * FROM sport")
    public List<SportDB> getSportDB();

    @Query("SELECT * FROM team")
    public List<TeamDB> getTeamDB();

    @Insert
    public void insertAthleteLocal(AthleteDB athlete);

    @Insert
    public void insertSportLocal(SportDB sport);

    @Insert
    public void insertTeamLocal(TeamDB team);

    @Delete
    public void deleteAthleteLocal(AthleteDB athlete);

    @Delete
    public void deleteSportLocal(SportDB sport);

    @Delete
    public void deleteTeamLocal(TeamDB team);

    @Update
    public void updateAthleteLocal(AthleteDB athlete);

    @Update
    public void updateSportLocal(SportDB sport);

    @Update
    public void updateTeamLocal(TeamDB team);
}
