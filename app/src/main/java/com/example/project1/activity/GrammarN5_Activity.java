package com.example.project1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.example.project1.R;
import com.example.project1.adapter.BumpoAdapter;
import com.example.project1.database.DataBaseHelper;
import com.example.project1.model.Grammar;

import java.util.ArrayList;
import java.util.List;

public class GrammarN5_Activity extends BaseActivity {

    private SearchView grammarN5Searchview;
    private RecyclerView grammarN5RecycleView;

    DataBaseHelper dataBaseHelper;
    List<Grammar> grammarList, allGrammarList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_n5_);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("NGỮ PHÁP N5");
        initView();

        grammarList = new ArrayList<>();
        allGrammarList = new ArrayList<>();
        dataBaseHelper = new DataBaseHelper(this);

        for (int i = 0; i < 25; i++){
            grammarList = dataBaseHelper.getGrammar(i);
            for (int j = 0; j < grammarList.size(); j++){
                allGrammarList.add(grammarList.get(j));
            }
        }

        BumpoAdapter adapter = new BumpoAdapter(this, allGrammarList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        grammarN5RecycleView.setLayoutManager(layoutManager);
        grammarN5RecycleView.setAdapter(adapter);


    }

    private void initView(){
        grammarN5Searchview = (SearchView) findViewById(R.id.grammarN5_searchview);
        grammarN5RecycleView = (RecyclerView) findViewById(R.id.grammarN5_recycleView);
    }

}
