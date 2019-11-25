package com.example.project1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.project1.R;

public class ExamN5Activity extends BaseActivity {
    Button examN5BtnVocabulary;
    Button examN5BtnGrammar;
    Button examN5BtnChinese;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_n5);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("TRẮC NGHIỆM N5 - JLPT 5 Level");
        examN5BtnVocabulary = (Button) findViewById(R.id.examN5_btnVocabulary);
        examN5BtnGrammar = (Button) findViewById(R.id.examN5_btnGrammar);
        examN5BtnChinese = (Button) findViewById(R.id.examN5_btnChinese);
        examN5BtnGrammar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExamN5Activity.this, QuizActivity.class);
                intent.putExtra("ExamN5", "A");
                startActivity(intent);

            }
        });
        examN5BtnChinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExamN5Activity.this, QuizActivity.class);
                intent.putExtra("ExamN5", "B");
                startActivity(intent);
            }
        });
        examN5BtnVocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExamN5Activity.this, QuizActivity.class);
                intent.putExtra("ExamN5", "C");

                startActivity(intent);
            }
        });
    }
}
