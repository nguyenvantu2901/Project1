package com.example.project1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;

import com.example.project1.R;

public class ExamN5Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_n5);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("TRẮC NGHIỆM N5 - JLPT 5 Level");
    }
}
