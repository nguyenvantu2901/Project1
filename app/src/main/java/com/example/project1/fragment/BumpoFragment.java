package com.example.project1.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project1.R;
import com.example.project1.adapter.BumpoAdapter;
import com.example.project1.adapter.KotobaAdapter;
import com.example.project1.database.DataBaseHelper;
import com.example.project1.model.Grammar;

import java.util.ArrayList;
import java.util.List;

import static com.example.project1.morefunc.DataSave.idSpinnerChose;

public class BumpoFragment extends Fragment {

    private RecyclerView recycleviewBunpo;
    DataBaseHelper dataBaseHelper;
    List<Grammar> grammarList;

    public BumpoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bumpo, container, false);
        initView(view);

        grammarList = new ArrayList<>();

        dataBaseHelper = new DataBaseHelper(getActivity());
        grammarList = dataBaseHelper.getGrammar(idSpinnerChose);

        BumpoAdapter adapter = new BumpoAdapter(getActivity(), grammarList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycleviewBunpo.setLayoutManager(layoutManager);
        recycleviewBunpo.setAdapter(adapter);

        return view;
    }

    private void initView(View view){
        recycleviewBunpo = (RecyclerView) view.findViewById(R.id.recycleview_Bunpo);
    }

}
