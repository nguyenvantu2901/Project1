package com.example.project1.activity;

import android.os.Bundle;

import com.example.project1.R;
import com.example.project1.activity.BaseActivity;

public class TranslateActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("TRA TỪ ĐIỂN");
    }
}
