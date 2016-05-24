package com.example.cristobal.i_lend;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends Activity {
    ListView lv;
    Button bntAddActivity, btnRefresh;
    ArrayList<String> players=new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        bntAddActivity=(Button)findViewById(R.id.button_AddActivity);
        btnRefresh=(Button)findViewById(R.id.button_refresh);

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDB();
            }
        });

        bntAddActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ListViewActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        lv=(ListView) findViewById(R.id.listView1);
        lv.setBackgroundColor(Color.LTGRAY);

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,players);

        final DBAdapter db=new DBAdapter(this);

        initDB();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
                                    long id) {
                // TODO Auto-generated method stub

                Toast.makeText(getApplicationContext(), players.get(pos), Toast.LENGTH_SHORT).show();

            }
        });



    }//onCreate

    public void initDB(){

        final DBAdapter db=new DBAdapter(this);
        players.clear();

        //OPEN
        db.openDB();

        //RETRIEVE
        Cursor c=db.getAllNames();

        while(c.moveToNext()){
            String name=c.getString(1);
            players.add(name);
        }//While

        lv.setAdapter(adapter);

        db.close();
    }//initDB

}
