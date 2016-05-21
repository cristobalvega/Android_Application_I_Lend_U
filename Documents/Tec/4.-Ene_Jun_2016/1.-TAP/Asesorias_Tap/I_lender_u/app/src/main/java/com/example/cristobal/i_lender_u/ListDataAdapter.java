package com.example.cristobal.i_lender_u;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristobal on 5/19/16.
 */
public class ListDataAdapter extends ArrayAdapter {
    List list = new ArrayList();

    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHander{
        TextView NAME,WHO;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row=convertView;
        LayoutHander layoutHander;
        if(row==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHander=new LayoutHander();
            layoutHander.NAME=(TextView)row.findViewById(R.id.text_user_name);
            layoutHander.WHO=(TextView)row.findViewById(R.id.text_user_who);
            row.setTag(layoutHander);
        }
        else{
            layoutHander=(LayoutHander)row.getTag();

        }

        DataProvider dataProvider=(DataProvider)this.getItem(position);
        layoutHander.NAME.setText(dataProvider.getName());
        layoutHander.WHO.setText(dataProvider.getWho());

        return row;
    }
}
