package com.example.project1.model;

public class Kotoba {

    private int kotoba_id, lesson_id;
    private String hiragana, kanji, roumaji, cn_mean, mean, sound;

    public int getKotoba_id() {
        return kotoba_id;
    }

    public void setKotoba_id(int kotoba_id) {
        this.kotoba_id = kotoba_id;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public String getHiragana() {
        return hiragana;
    }

    public void setHiragana(String hiragana) {
        this.hiragana = hiragana;
    }

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public String getRoumaji() {
        return roumaji;
    }

    public void setRoumaji(String roumaji) {
        this.roumaji = roumaji;
    }

    public String getCn_mean() {
        return cn_mean;
    }

    public void setCn_mean(String cn_mean) {
        this.cn_mean = cn_mean;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
