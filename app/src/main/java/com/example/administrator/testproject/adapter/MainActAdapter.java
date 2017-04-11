package com.example.administrator.testproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.testproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ds on 2016/10/20.
 */
public class MainActAdapter extends BaseAdapter{
    private List<String> data = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public MainActAdapter(List<String> data, Context context) {
        this.data = data;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.adapter_mainact,null);
            holder = new ViewHolder();
            holder.tv = (TextView) view.findViewById(R.id.adapter_tv);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv.setText(data.get(i));
        return view;
    }
    class ViewHolder{
        TextView tv;
    }
}
