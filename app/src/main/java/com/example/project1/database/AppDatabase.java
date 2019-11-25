package com.example.project1.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.project1.model.Alphabet;
import com.example.project1.model.TextHistory;

@Database(entities = {Alphabet.class, TextHistory.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract AlphabetDAO alphabetDAO();
    public abstract HistoryDAO historyDAO();
    //từ vựng
    //ngữ pháp
    //nghe
    //kanji

}
