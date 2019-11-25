package com.example.project1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.model.Kaiwa;

import java.util.List;

public class KaiwaAdapter extends BaseAdapter {

    private Context context;
    private List<Kaiwa> list;

    public KaiwaAdapter(Context context, List<Kaiwa> list) {
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

        final View convertView = LayoutInflater.from(context).inflate(R.layout.item_kaiwa, viewGroup, false);

        TextView tvCharacter = (TextView) convertView.findViewById(R.id.tvCharacter);
        TextView tvKaiwa = (TextView) convertView.findViewById(R.id.tvKaiwa);
        TextView tvMean = (TextView) convertView.findViewById(R.id.tvMean);

        Kaiwa k = list.get(i);

        tvCharacter.setText(k.getCharacter());
        tvKaiwa.setText(k.getKaiwa());
        tvMean.setText(k.getMean());

        return convertView;
    }
}
