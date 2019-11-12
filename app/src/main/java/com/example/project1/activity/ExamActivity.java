package com.example.project1.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project1.R;
import com.example.project1.activity.BaseActivity;

public class ExamActivity extends BaseActivity {

    private Button examBtnN5;
    private Button examBtnN4;
    private Button examBtnN3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("LUYỆN THI");
        initView();
        examBtnN5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ExamN5Activity.class);
            }
        });


    }

    private void initView(){

        examBtnN5 = (Button) findViewById(R.id.exam_btnN5);
        examBtnN4 = (Button) findViewById(R.id.exam_btnN4);
        examBtnN3 = (Button) findViewById(R.id.exam_btnN3);

    }
}
