package com.example.cristobal.i_lender_u;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnAddActivity, btnViewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddActivity=(Button)findViewById(R.id.buttonAddActivity);
        btnViewActivity=(Button)findViewById(R.id.buttonViewActivity);

        btnAddActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Addintent=new Intent(MainActivity.this,AddActivity.class);
                startActivity(Addintent);
            }
        });

        btnViewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent viewContactIntent=new Intent(MainActivity.this,DataListActivity.class);
                startActivity(viewContactIntent);*/

                Intent Addintent=new Intent(MainActivity.this,DataListActivity.class);
                startActivity(Addintent);
                Toast.makeText(MainActivity.this,"Holi",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
