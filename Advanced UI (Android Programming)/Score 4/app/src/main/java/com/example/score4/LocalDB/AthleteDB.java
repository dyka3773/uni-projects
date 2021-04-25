
package com.example.score4.LocalDB;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.google.android.gms.maps.model.LatLng;

@Entity (tableName = "athlete", primaryKeys = "aid", foreignKeys = {
        @ForeignKey(entity = SportDB.class, parentColumns = "sid", childColumns = "asid")},
        indices = {@Index(value = "asid", unique = true)})
public class AthleteDB {
    @ColumnInfo (name = "aid") @NonNull
    private int AID;

    private String f_name;

    private String l_name;

    private String city;

    private String country;

    @ColumnInfo (name = "asid")
    private int SID;

    private int b_year;

    private double hometown;

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
