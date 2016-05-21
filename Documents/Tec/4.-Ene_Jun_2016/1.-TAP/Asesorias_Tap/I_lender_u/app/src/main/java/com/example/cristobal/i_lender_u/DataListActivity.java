package com.example.cristobal.i_lender_u;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

public class DataListActivity extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    LendDB lendDB;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_layout);

        listView=(ListView)findViewById(R.id.list_view);
        listDataAdapter=new ListDataAdapter(getApplicationContext(),R.layout.row_layout);

        listView.setAdapter(listDataAdapter);

        lendDB=new LendDB(getApplicationContext());
        sqLiteDatabase=lendDB.getReadableDatabase();

        cursor=lendDB.getInfo(sqLiteDatabase);

        if(cursor.moveToFirst()){
            do{
                String name, who;
                name=cursor.getString(0);
                who=cursor.getString(1);

                DataProvider dataProvider = new DataProvider(name,who);

                listDataAdapter.add(dataProvider);

            }while(cursor.moveToNext());

        }
    }



}
