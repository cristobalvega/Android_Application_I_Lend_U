package com.example.cristobal.ilend_lite;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    Button btnHomeU,btnViewU,btnUpdateU;
    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        //dataBase=new DataBase(this);

        //view();

        btnHomeU=(Button)findViewById(R.id.button_HomeU);
        btnViewU=(Button)findViewById(R.id.button_viewAllU);
        btnUpdateU=(Button)findViewById(R.id.button_updateU);

        btnHomeU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }//onCreate

    public void view(){
        btnViewU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor=dataBase.getAllData();

                if(cursor.getCount()==0){
                    Toast.makeText(UpdateActivity.this, "Nothing to show", Toast.LENGTH_SHORT).show();
                    return;
                }//if

                StringBuffer stringBuffer=new StringBuffer();
                while(cursor.moveToNext()){
                    stringBuffer.append("Name  :"+cursor.getString(1)+"\n");
                    stringBuffer.append("Thing :"+cursor.getString(2)+"\n");
                    stringBuffer.append("Date  :"+cursor.getString(3));
                }//while
                showMessage("Data",stringBuffer.toString());
            }//while
        });
    }//view

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }//showMessage
}//Update
