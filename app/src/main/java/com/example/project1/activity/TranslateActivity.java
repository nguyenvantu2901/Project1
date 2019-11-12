package com.example.project1.activity;

import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import com.example.project1.R;
import com.example.project1.activity.BaseActivity;
import com.example.project1.adapter.ViewPagerAdapter;
import com.example.project1.fragment.DictionaryFragment;
import com.example.project1.fragment.HistoryFragment;
import com.google.android.material.tabs.TabLayout;

public class TranslateActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("TRA TỪ ĐIỂN");
        initView();

        addTabs(viewPager);
        tabLayout.setupWithViewPager(viewPager);


    }

    public void addTabs(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFrm(new DictionaryFragment(), "Từ điển");
        adapter.addFrm(new HistoryFragment(), "Lịch sử");
        viewPager.setAdapter(adapter);
    }

    private void initView(){
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

}
