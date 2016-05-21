package com.example.cristobal.i_lender_u;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    EditText editTextName,editTextWho;
    Button btnHome, btnAdd;
    Context context= this;
    LendDB lendDB;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editTextName=(EditText)findViewById(R.id.editTextName);
        editTextWho=(EditText)findViewById(R.id.editTextWho);

        btnHome=(Button)findViewById(R.id.btnHomeADDXML);
        btnAdd=(Button)findViewById(R.id.btnAddActivity);
        addInfo();


        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainIntent= new Intent(AddActivity.this,MainActivity.class);
                startActivity(MainIntent);
            }
        });

    }


    public void addUser(View view){
        String name = editTextName.getText().toString();
        String who = editTextWho.getText().toString();

        lendDB = new LendDB(context);
        sqLiteDatabase = lendDB.getWritableDatabase();
        lendDB.addInformation(name, who, sqLiteDatabase);

        Toast.makeText(getBaseContext(), "Data Added", Toast.LENGTH_SHORT).show();
        lendDB.close();
    }

    public void addInfo(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = lendDB.insertData(editTextName.getText().toString(), editTextWho.getText().toString());

                if (isInserted)
                    Toast.makeText(AddActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();

                else
                    Toast.makeText(AddActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
            }

        }
        // Toast.makeText(AddActivity.this,"Holi",Toast.LENGTH_LONG).show()
         );
    }//addInfo


}
