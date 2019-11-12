package com.example.project1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.example.project1.R;

public class GrammarN5_Activity extends BaseActivity {

    private SearchView grammarN5Searchview;
    private RecyclerView grammarN5RecycleView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_n5_);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("NGỮ PHÁP N5");
        initView();
    }

    private void initView(){
        grammarN5Searchview = (SearchView) findViewById(R.id.grammarN5_searchview);
        grammarN5RecycleView = (RecyclerView) findViewById(R.id.grammarN5_recycleView);
    }

}
