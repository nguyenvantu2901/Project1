package com.example.project1.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project1.R;
import com.example.project1.activity.BaseActivity;

public class GrammarActivity extends BaseActivity {

    private Button grammarBtnN5;
    private Button grammarBtnN4;
    private Button grammarBtnN3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("NGỮ PHÁP");
        initView();

        grammarBtnN5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(GrammarN5_Activity.class);
            }
        });
    }

    private void initView(){
        grammarBtnN5 = (Button) findViewById(R.id.grammar_btnN5);
        grammarBtnN4 = (Button) findViewById(R.id.grammar_btnN4);
        grammarBtnN3 = (Button) findViewById(R.id.grammar_btnN3);
    }
}
