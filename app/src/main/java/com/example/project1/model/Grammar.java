package com.example.project1.model;

public class Grammar {
    private int grammar_id, lesson_id;
    private String name, uname, content;

    public int getGrammar_id() {
        return grammar_id;
    }

    public void setGrammar_id(int grammar_id) {
        this.grammar_id = grammar_id;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
