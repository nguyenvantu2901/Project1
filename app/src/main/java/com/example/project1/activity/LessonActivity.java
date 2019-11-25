package com.example.project1.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project1.R;
import com.example.project1.activity.BaseActivity;

public class LessonActivity extends BaseActivity {

    private Button lessonBtnN5;
    private Button lessonBtnN4;
    private Button lessonBtnN3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("BÀI HỌC");
        initView();

        lessonBtnN5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(LessionN5Activity.class);
            }
        });
    }

    private void initView(){
        lessonBtnN5 = (Button) findViewById(R.id.lesson_btnN5);
        lessonBtnN4 = (Button) findViewById(R.id.lesson_btnN4);
        lessonBtnN3 = (Button) findViewById(R.id.lesson_btnN3);

    }
}
