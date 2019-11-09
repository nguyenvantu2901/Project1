package com.example.project1.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.project1.model.Alphabet;

@Database(entities = {Alphabet.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract AlphabetDAO alphabetDAO();
}
