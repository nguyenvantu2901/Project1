package com.example.project1.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.project1.ItemClickSupport;
import com.example.project1.R;
import com.example.project1.adapter.KanjiAdapter;
import com.example.project1.adapter.KotobaAdapter;
import com.example.project1.database.DataBaseHelper;
import com.example.project1.model.Kanji;

import java.util.ArrayList;
import java.util.List;

import static com.example.project1.morefunc.DataSave.idSpinnerChose;

public class KanjiFragment extends Fragment {

    private ListView lvKanji;
    DataBaseHelper dataBaseHelper;
    List<Kanji> kanjiList;
    KanjiAdapter kanjiAdapter;
    AlertDialog alertDialog;

    //Dialog view

    private TextView tvKanji;
    private TextView tvCNMean;
    private TextView tvKunyomi;
    private TextView tvMean;
    private TextView tvOnnyomi;
    private TextView tvNote;
    private ImageView imbCancel;


    public KanjiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_kanji, container, false);
        initView(view);

        kanjiList = new ArrayList<>();
        dataBaseHelper = new DataBaseHelper(getActivity());

        kanjiList = dataBaseHelper.getKanji(idSpinnerChose);

        kanjiAdapter = new KanjiAdapter(view.getContext(), kanjiList);
        lvKanji.setAdapter(kanjiAdapter);

        Log.e("kanji list", kanjiList.size() + "");

        lvKanji.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                clickItem(i, view);
                Log.e("click click", i + "");
            }
        });

        return view;
    }

    private void clickItem(int i, View view) {
        Kanji k = kanjiList.get(i);

        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        final View dialog = LayoutInflater.from(view.getContext()).inflate(R.layout.dialog_kanji_detail, null);
        builder.setView(dialog);

        tvKanji = (TextView) dialog.findViewById(R.id.tvKanji);
        tvCNMean = (TextView) dialog.findViewById(R.id.tvCNMean);
        tvKunyomi = (TextView) dialog.findViewById(R.id.tvKunyomi);
        tvMean = (TextView) dialog.findViewById(R.id.tvMean);
        tvOnnyomi = (TextView) dialog.findViewById(R.id.tvOnnyomi);
        tvNote = (TextView) dialog.findViewById(R.id.tvNote);
        imbCancel = (ImageView) dialog.findViewById(R.id.imbCancel);


        tvKanji.setText(k.getKanji());
        tvCNMean.setText(k.getCn_mean());
        tvKunyomi.setText(k.getKunyomi());
        tvOnnyomi.setText(k.getOnyomi());
        tvMean.setText(k.getMean());

        //Định dạng text
        String vd = "";
        String note = k.getNote();
        String[] splitStr = note.split("※");
        String[] output = new String[100];

        for (int j = 0; j < splitStr.length; j++){
            output[j] = "";
            String[] splitSub = splitStr[j].split("∴");

            for (int n = 0; n < splitSub.length; n++){
                output[j] =output[j] + splitSub[n] + "      ";
            }

            vd =  vd + " 。 " + output[j] + "\n";
        }
        tvNote.setText(vd);

        imbCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        alertDialog = builder.create();
//                alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog = builder.show();

    }

    private void initView(View view) {
        lvKanji = (ListView) view.findViewById(R.id.lv_Kanji);
    }
}
