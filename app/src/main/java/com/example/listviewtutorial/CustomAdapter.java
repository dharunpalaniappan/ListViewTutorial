package com.example.listviewtutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Player> datalist;

    public CustomAdapter(Context context, ArrayList<Player>datalist)
    {
        this.context=context;
        this.datalist=datalist;
    }

    @Override
    public int getCount(){
        return datalist.size();
    }

    @Override
    public Object getItem(int i) {
        return datalist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.listitem, viewGroup, false);
        }
        Player data = datalist.get(i);
        TextView txt1 = view.findViewById(R.id.pname);
        txt1.setText(data.getplayer());
        TextView txt2 = view.findViewById(R.id.ptag);
        txt2.setText(data.gettag());
        return view;
    }
}
