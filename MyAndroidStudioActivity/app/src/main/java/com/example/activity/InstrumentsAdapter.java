package com.example.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class InstrumentsAdapter extends ArrayAdapter<Instruments> {
    private int resourceId;

    public InstrumentsAdapter(Context context, int textViewResourceId, List<Instruments> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Instruments instruments = getItem(position); // 获取当前项的实例

        View view;
        ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.instrumentImage = view.findViewById(R.id.instrument_image);
            viewHolder.instrumentName = view.findViewById(R.id.instrument_name);
            view.setTag(viewHolder); // 缓存 viewHolder 对象
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        if (instruments != null) {
            viewHolder.instrumentImage.setImageResource(instruments.getImageId());
            viewHolder.instrumentName.setText(instruments.getName());
        }

        return view;
    }

    // 内部类用于优化性能（ViewHolder 模式）
    static class ViewHolder {
        ImageView instrumentImage;
        TextView instrumentName;
    }
}