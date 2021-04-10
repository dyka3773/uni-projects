package com.example.score4.LocalDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAO {
    //Melontike Thanasi tsekare an auto doueleuei h estw plhsiazei se kati swsto -Parontikos Thanasis
    //Isws xreiastei na dwseis tableName kai name stis klaseis twn pinakwn idk
    //Epishs na syplhrwseis oti allo insert/delete/update xreiastei

    @Query("SELECT * FROM AthleteDB")
    public List<AthleteDB> getAthleteDB();

    @Query("SELECT * FROM SportDB")
    public List<SportDB> getSportDB();

    @Query("SELECT * FROM TeamDB")
    public List<TeamDB> getTeamDB();
}
