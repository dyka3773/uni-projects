package com.example.score4.LocalDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {AthleteDB.class, SportDB.class, TeamDB.class}, version = 1)
public abstract class LocalDatabase extends RoomDatabase {
    public abstract DAO dao();
}
