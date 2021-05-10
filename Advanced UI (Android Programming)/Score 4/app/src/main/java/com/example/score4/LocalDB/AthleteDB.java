package com.example.score4.LocalDB;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.google.android.gms.maps.model.LatLng;

@Entity (tableName = "athlete", primaryKeys = "aid", foreignKeys = {
        @ForeignKey(entity = SportDB.class, parentColumns = "sid", childColumns = "asid")})//, indices = {@Index(value = "asid", unique = true)})
public class AthleteDB {
    @ColumnInfo (name = "aid") @NonNull
    private int AID;

    @ColumnInfo (name = "FirstName")
    private String f_name;

    @ColumnInfo (name = "LastName")
    private String l_name;

    @ColumnInfo (name = "City")
    private String city;

    @ColumnInfo (name = "Country")
    private String country;

    @ColumnInfo (name = "asid")
    private int SID;

    @ColumnInfo (name = "BirthdayYear")
    private int b_year;

    @ColumnInfo (name = "Hometown")
    private double hometown;

    public AthleteDB() {
    }

    public AthleteDB(int AID, String f_name, String l_name, String city, String country, int SID, int b_year, double hometown) {
        this.AID = AID;
        this.f_name = f_name;
        this.l_name = l_name;
        this.city = city;
        this.country = country;
        this.SID = SID;
        this.b_year = b_year;
        this.hometown = hometown;
    }

    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
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

    public int getB_year() {
        return b_year;
    }

    public void setB_year(int b_year) {
        this.b_year = b_year;
    }

    public double getHometown() {
        return hometown;
    }

    public void setHometown(double hometown) {
        this.hometown = hometown;
    }
}
