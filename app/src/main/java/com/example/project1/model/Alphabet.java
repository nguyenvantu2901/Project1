package com.example.project1.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Alphabet {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "hiragana")
    public String hiragana;

    @ColumnInfo(name = "katakana")
    public String katakana;

    @ColumnInfo(name = "romari")
    public String romari;

    @ColumnInfo(name = "sound")
    public String sound;

    public Alphabet(int id, String hiragana, String katakana, String romari, String sound) {
        this.id = id;
        this.hiragana = hiragana;
        this.katakana = katakana;
        this.romari = romari;
        this.sound = sound;
    }
}
