package com.example.score4.LocalDB;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

//import com.google.android.gms.maps.model.LatLng;

@Entity (tableName = "team", primaryKeys = "tid", foreignKeys = {
        @ForeignKey(entity = SportDB.class, parentColumns = "sid", childColumns = "tsid")})
public class TeamDB {

    public TeamDB() {
    }

    public TeamDB(int TID, String teamName, String s_name, String city, String country, int SID, int e_year, double hometown) {
        this.TID = TID;
        this.teamName = teamName;
        this.s_name = s_name;
        this.city = city;
        this.country = country;
        this.SID = SID;
        this.e_year = e_year;
        this.hometown = hometown;
    }

    @ColumnInfo (name = "tid") @NonNull
    private int TID;

    private String teamName;

    private String s_name;

    private String city;

    private String country;

    @ColumnInfo (name = "tsid")
    private int SID;

    private int e_year;

    private double hometown;

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public int getE_year() {
        return e_year;
    }

    public void setE_year(int e_year) {
        this.e_year = e_year;
    }

    public double getHometown() {
        return hometown;
    }

    public void setHometown(double hometown) {
        this.hometown = hometown;
    }
}
