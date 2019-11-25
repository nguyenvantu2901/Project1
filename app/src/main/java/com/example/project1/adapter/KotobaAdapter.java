package com.example.project1.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.model.Kotoba;

import java.util.List;

public class KotobaAdapter extends BaseAdapter {
    Context context;
    List<Kotoba> kotobas;

    public KotobaAdapter(Context context, List<Kotoba> kotobas) {
        this.context = context;
        this.kotobas = kotobas;
    }

    @Override
    public int getCount() {
        return kotobas.size();
    }

    @Override
    public Object getItem(int i) {
        return kotobas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View convertView = LayoutInflater.from(context).inflate(R.layout.item_kotoba, viewGroup, false);

        TextView tvHiragana = (TextView) convertView.findViewById(R.id.tvHiragana);
        TextView tvMean = (TextView) convertView.findViewById(R.id.tvMean);
        ImageView imgPro = (ImageView) convertView.findViewById(R.id.imgPro);

        Kotoba word = kotobas.get(i);

        if (!(word.getKanji().equals(""))){
            tvHiragana.setText(word.getHiragana() + " / " + word.getKanji());
        }else {
            tvHiragana.setText(word.getHiragana());
        }

        tvMean.setText(word.getMean());

        if (i % 2 == 1) {
            convertView.setBackgroundColor(Color.WHITE);
        }

        return convertView;
    }
}
