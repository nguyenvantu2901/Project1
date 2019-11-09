package com.example.project1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.model.Alphabet;

import java.util.List;

public class AlphabetAdapter extends RecyclerView.Adapter<AlphabetAdapter.MyViewHolder> {

    Context mContext;
    List<Alphabet> list;

    public AlphabetAdapter(Context mContext, List<Alphabet> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public AlphabetAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alphabet, parent, false);
        final MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AlphabetAdapter.MyViewHolder holder, int position) {

        Alphabet a = list.get(position);

        holder.tvHi.setText(a.hiragana);
        holder.tvKa.setText(a.katakana);
        holder.tvRo.setText(a.romari);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvHi;
        private TextView tvRo;
        private TextView tvKa;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvHi = (TextView) itemView.findViewById(R.id.tvHi);
            tvRo = (TextView) itemView.findViewById(R.id.tvRo);
            tvKa = (TextView) itemView.findViewById(R.id.tvKa);

        }
    }
}
