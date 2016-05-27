package com.example.cristobal.ilend_lite;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleateActivity extends AppCompatActivity {
    Button btnHome, btnDelete, btnView;
    DataBase dataBase;
    EditText txtID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleate);

        dataBase=new DataBase(this);

        btnHome=(Button)findViewById(R.id.button_homeDelete);
        btnDelete=(Button)findViewById(R.id.button_deleteD);
        btnView=(Button)findViewById(R.id.button_viewDelete);
        txtID=(EditText)findViewById(R.id.editText_ID);

        delete();
        view();

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DeleateActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }//onCreate


    public void delete(){
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleated=dataBase.delateData(txtID.getText().toString());

                if(deleated>0){
                    Toast.makeText(DeleateActivity.this,"Deleated Row", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(DeleateActivity.this, "Not Deleated ", Toast.LENGTH_SHORT).show();

            }
        });

    }//delete

    public void view(){
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor=dataBase.getAllData();

                if(cursor.getCount()==0){
                    Toast.makeText(DeleateActivity.this, "Nothing to show", Toast.LENGTH_SHORT).show();
                    return;
                }//if

                StringBuffer stringBuffer=new StringBuffer();
                while(cursor.moveToNext()){
                    stringBuffer.append("Id    :"+cursor.getString(0)+"\n");
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

}//DeleteActivity
