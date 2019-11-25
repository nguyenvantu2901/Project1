package com.example.project1.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.project1.R;
import com.example.project1.activity.LessionN5Activity;
import com.example.project1.adapter.KotobaAdapter;
import com.example.project1.database.DataBaseHelper;
import com.example.project1.model.Kotoba;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.List;

import static com.example.project1.morefunc.DataSave.idSpinnerChose;

public class KotobaFragment extends Fragment {

    private ListView lvKotoba;
    private FloatingActionButton fabKotobaPlay;

    List<Kotoba> kotobaList;
    KotobaAdapter kotobaAdapter;
    DataBaseHelper dataBaseHelper;

    public KotobaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kotoba, container, false);
        initView(view);

        kotobaList = new ArrayList<>();

        dataBaseHelper = new DataBaseHelper(getActivity());
        kotobaList = dataBaseHelper.getKotoba(idSpinnerChose);

        kotobaAdapter = new KotobaAdapter(getContext(), kotobaList);
        lvKotoba.setAdapter(kotobaAdapter);

        return view;
    }

    private void initView(View view){
        lvKotoba = (ListView) view.findViewById(R.id.lvKotoba);
        fabKotobaPlay = (FloatingActionButton) view.findViewById(R.id.fab_kotoba_Play);
    }

}
