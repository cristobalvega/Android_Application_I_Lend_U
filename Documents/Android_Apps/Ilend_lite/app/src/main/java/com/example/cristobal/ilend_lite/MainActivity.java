package com.example.cristobal.ilend_lite;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    Button btnAdd,btnView,btnDelete;
    EditText txtName,txtThing;
    DataBase dataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd=(Button)findViewById(R.id.button_add);
        btnView=(Button)findViewById(R.id.button_view);
        btnDelete=(Button)findViewById(R.id.button_delete);
        txtName=(EditText)findViewById(R.id.text_name);
        txtThing=(EditText)findViewById(R.id.text_thing);
        datePicker=(DatePicker)findViewById(R.id.datePicker);

        dataBase=new DataBase(this);

        add();
        view();

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DeleateActivity.class);
                startActivity(intent);
            }
        });



    }//onCreate


    public void add(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted=dataBase.insertData(
                        txtName.getText().toString(),
                        txtThing.getText().toString(),
                        datePicker.getDayOfMonth()+" /"+
                        datePicker.getMonth()+" /"+
                        datePicker.getYear()+" /");

                if (isInserted){
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
            }
        });
    }//add

    public void view(){
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor=dataBase.getAllData();

                if(cursor.getCount()==0){
                    Toast.makeText(MainActivity.this, "Nothing to show", Toast.LENGTH_SHORT).show();
                    return;
                }//if

                StringBuffer stringBuffer=new StringBuffer();
                while(cursor.moveToNext()){
                    stringBuffer.append("Name  :"+cursor.getString(1)+"\n");
                    stringBuffer.append("Thing :"+cursor.getString(2)+"\n");
                    stringBuffer.append("Date  :"+cursor.getString(3)+"\n"+"\n");
                }//while
                showMessage("Data",stringBuffer.toString());
            }//onClick
        });
    }//view

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }//showMessage


}//Main
