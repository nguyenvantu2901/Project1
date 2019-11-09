package com.example.project1.activity;

import android.os.Bundle;

import com.example.project1.R;
import com.example.project1.activity.BaseActivity;

public class HelpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("TRỢ GIÚP");
    }
}
