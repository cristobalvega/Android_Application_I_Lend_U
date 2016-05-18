package com.example.cristobal.i_lender_u;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnAddActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddActivity=(Button)findViewById(R.id.buttonAddActivity);


        btnAddActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Addintent=new Intent(MainActivity.this,AddActivity.class);
                startActivity(Addintent);
            }
        });
    }
}
