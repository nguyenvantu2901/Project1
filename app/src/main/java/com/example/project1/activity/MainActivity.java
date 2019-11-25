package com.example.project1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.room.Room;

import com.example.project1.R;
import com.example.project1.database.AppDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends BaseActivity {

    private FloatingActionButton btnFab;
    private LinearLayout grammar;
    private LinearLayout translate;
    private LinearLayout lesson;
    private LinearLayout exam;
    private LinearLayout alphabet;
    private LinearLayout help;

    public static AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        db = Room.databaseBuilder(this,
                AppDatabase.class, "DuAnDemo2.db").allowMainThreadQueries().build();


        alphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(AlphabetActivity.class);
            }
        });

        grammar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(GrammarActivity.class);
            }
        });

        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(TranslateActivity.class);
            }
        });

        lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(LessonActivity.class);
            }
        });

        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ExamActivity.class);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(HelpActivity.class);
            }
        });

    }

    private void initView(){
        btnFab = (FloatingActionButton) findViewById(R.id.btnFab);
        grammar = (LinearLayout) findViewById(R.id.grammar);
        translate = (LinearLayout) findViewById(R.id.translate);
        lesson = (LinearLayout) findViewById(R.id.lesson);
        exam = (LinearLayout) findViewById(R.id.exam);
        alphabet = (LinearLayout) findViewById(R.id.alphabet);
        help = (LinearLayout) findViewById(R.id.help);

    }
}
