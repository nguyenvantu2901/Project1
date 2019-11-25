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

    @ColumnInfo(name = "gif_hiragana")
    public String gif_hiragana;

    @ColumnInfo(name = "gif_katakana")
    public String gif_katakana;

    public Alphabet(int id, String hiragana, String katakana, String romari, String sound, String gif_hiragana, String gif_katakana) {
        this.id = id;
        this.hiragana = hiragana;
        this.katakana = katakana;
        this.romari = romari;
        this.sound = sound;
        this.gif_hiragana = gif_hiragana;
        this.gif_katakana = gif_katakana;
    }
}
