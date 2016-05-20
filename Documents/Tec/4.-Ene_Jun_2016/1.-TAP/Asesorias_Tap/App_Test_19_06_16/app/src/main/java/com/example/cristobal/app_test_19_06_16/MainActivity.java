package com.example.cristobal.app_test_19_06_16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnHolis,btnHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHolis=(Button)findViewById(R.id.holis);
        btnHello=(Button)findViewById(R.id.hello);


        btnHolis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent holisIntent=new Intent(MainActivity.this,HolisActivity.class);
                startActivity(holisIntent);
            }
        });

        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent helloIntent=new Intent(MainActivity.this,HelloActivity.class);
                startActivity(helloIntent);
            }
        });
    }
}
