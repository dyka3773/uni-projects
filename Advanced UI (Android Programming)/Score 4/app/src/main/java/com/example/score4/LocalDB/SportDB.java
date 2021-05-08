package com.example.score4.LocalDB;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity (tableName = "sport" )
public class SportDB {

    public SportDB() {
    }

    public SportDB(int sportID, @NonNull String sportName, String sportType, String gender) {
        this.sportID = sportID;
        this.sportName = sportName;
        this.sportType = sportType;
        this.gender = gender;
    }

    @PrimaryKey
    @ColumnInfo (name = "sid") @NonNull
    private int sportID;

    @ColumnInfo (name = "sport") @NonNull
    private String sportName;

    private String sportType;

    private String gender;

    public int getSportID() {
        return sportID;
    }

    public void setSportID(int sportID) {
        this.sportID = sportID;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
