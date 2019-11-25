package com.example.project1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.project1.R;
import com.example.project1.adapter.ViewPagerAdapter;
import com.example.project1.database.DataBaseHelper;
import com.example.project1.fragment.BumpoFragment;
import com.example.project1.fragment.KaiwaFragment;
import com.example.project1.fragment.KanjiFragment;
import com.example.project1.fragment.KotobaFragment;
import com.example.project1.model.Kotoba;
import com.google.android.material.tabs.TabLayout;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.example.project1.morefunc.DataSave.idSpinnerChose;

public class LessionN5Activity extends BaseActivity {

    private Toolbar toolbarLession;
    private MaterialSpinner spinnerNav;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public DataBaseHelper dataBaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lession_n5);
        initView();

        setSupportActionBar(toolbarLession);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("BÀI HỌC N5");
        getLession(spinnerNav);
        Log.e("spinner selected index", spinnerNav.getSelectedIndex()+"");

        addTabs(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        dataBaseHelper = new DataBaseHelper(this);
        dataBaseHelper.createDataBase();

        spinnerNav.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                idSpinnerChose = spinnerNav.getSelectedIndex()+1;
                addTabs(viewPager);
            }
        });
    }



    public void addTabs(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFrm(new KotobaFragment(), "Từ vựng");
        adapter.addFrm(new BumpoFragment(), "Ngữ pháp");
        adapter.addFrm(new KaiwaFragment(), "Hội thoại");
        adapter.addFrm(new KanjiFragment(), "Chữ Hán");
        viewPager.setAdapter(adapter);
    }

    private void initView() {
        toolbarLession = (Toolbar) findViewById(R.id.toolbar_lession);
        spinnerNav = (MaterialSpinner) findViewById(R.id.spinner_nav);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    public void getLession(MaterialSpinner spinner) {

        List<String> lessions = new ArrayList<>();
        for (int i = 1; i < 26; i++){
            lessions.add("Bài "+i);
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lessions);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);


    }



}
