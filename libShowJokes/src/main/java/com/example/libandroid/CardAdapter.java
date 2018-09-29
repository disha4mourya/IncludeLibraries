package com.example.libandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CardAdapter extends BaseAdapter {
    private String[] jokesList;
    private int[] colorIds = {R.color.colorYellow, R.color.colorSkyBlue, R.color.colorLightSkyBlue, R.color.colorCard
            , R.color.colorLightAccent, R.color.colorPrimary};

    CardAdapter(String[] jokesList) {
        this.jokesList = jokesList;
    }

    @Override
    public int getCount() {
        return jokesList.length;
    }

    @Override
    public String getItem(int position) {
        return jokesList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout
                    .item_card, parent, false);
        }
        TextView tvJoke = convertView.findViewById(R.id.tvJoke);
        tvJoke.setText(jokesList[position]);
        if (position < colorIds.length)
            convertView.setBackgroundResource(colorIds[position]);
        return convertView;
    }
}