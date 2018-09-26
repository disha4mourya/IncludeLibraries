package com.example.libandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CardAdapter extends BaseAdapter {
    private String[] resIds;

    CardAdapter(String[] resIds) {
        this.resIds = resIds;
    }

    @Override
    public int getCount() {
        return resIds.length;
    }

    @Override
    public String getItem(int position) {
        return resIds[position];
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
        tvJoke.setText(resIds[position]);
        return convertView;
    }
}