package com.example.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

//InstrumentsAdapter 是自定义适配器，用于将 Instruments 对象绑定到 ListView 的每个条目中。
//使用 ViewHolder 模式提高性能。
public class InstrumentsAdapter extends ArrayAdapter<Instruments> {
    private int resourceId; // 每个列表项使用的布局资源 ID

    /**  	构造方法
         @param context 上下文对象
         @param textViewResourceId 列表项布局资源 ID
         @param objects 乐器对象列表				*/
    public InstrumentsAdapter(Context context, int textViewResourceId, List<Instruments> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    // 重写 getView 方法，为 ListView 的每一项加载布局并绑定数据
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // 获取当前项的乐器对象
        Instruments instruments = getItem(position);

        View view;
        ViewHolder viewHolder;

        // 判断是否可复用已有的视图（提高性能）
        if (convertView == null) {
            // 若不可复用，则手动加载新的布局，并创建 ViewHolder 来缓存子控件引用
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.instrumentImage = view.findViewById(R.id.instrument_image);
            viewHolder.instrumentName = view.findViewById(R.id.instrument_name);
            view.setTag(viewHolder); // 将 viewHolder 缓存到 view 中
        } else {
            // 若已有可复用的视图，则直接读取缓存的 ViewHolder
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        // 将乐器对象的数据设置到对应控件上
        if (instruments != null) {
            viewHolder.instrumentImage.setImageResource(instruments.getImageId());
            viewHolder.instrumentName.setText(instruments.getName());
        }
        return view;
    }

    // 静态内部类：用于缓存子控件，避免频繁 findViewById 调用，提高列表滚动性能
    static class ViewHolder {
        ImageView instrumentImage;
        TextView instrumentName;
    }
}