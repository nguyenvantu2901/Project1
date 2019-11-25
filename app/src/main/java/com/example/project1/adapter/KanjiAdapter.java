package com.example.project1.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.model.Kanji;

import java.util.List;

public class KanjiAdapter extends BaseAdapter {

    private Context context;
    private List<Kanji> list;

    public KanjiAdapter(Context context, List<Kanji> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View convertView = LayoutInflater.from(context).inflate(R.layout.item_kanji, viewGroup, false);

        TextView tvKanji = (TextView) convertView.findViewById(R.id.tvKanji);
        TextView tvMean = (TextView) convertView.findViewById(R.id.tvMean);
        TextView tvKunyomi = (TextView) convertView.findViewById(R.id.tvKunyomi);
        TextView tvOnyomi = (TextView) convertView.findViewById(R.id.tvOnyomi);
        TextView tvCNMean = (TextView) convertView.findViewById(R.id.tvCNMean);


       Kanji kj = list.get(i);

       tvKanji.setText(kj.getKanji());
       tvMean.setText(kj.getMean());
       tvKunyomi.setText(kj.getKunyomi());
       tvOnyomi.setText(kj.getOnyomi());
       tvCNMean.setText(kj.getCn_mean());

        if (i % 2 == 1) {
            convertView.setBackgroundColor(Color.WHITE);
        }

        return convertView;
    }
}
