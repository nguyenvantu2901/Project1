package com.example.project1.model;

public class Kanji {
    private int kanji_id, lesson_id;
    private String kanji, cn_mean, mean, onyomi, kunyomi, note;

    public int getKanji_id() {
        return kanji_id;
    }

    public void setKanji_id(int kanji_id) {
        this.kanji_id = kanji_id;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
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

    public String getOnyomi() {
        return onyomi;
    }

    public void setOnyomi(String onyomi) {
        this.onyomi = onyomi;
    }

    public String getKunyomi() {
        return kunyomi;
    }

    public void setKunyomi(String kunyomi) {
        this.kunyomi = kunyomi;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
