package com.example.cristobal.i_lend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    EditText txtName, txtPos;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        txtName=(EditText)findViewById(R.id.editText_Name);
        txtPos=(EditText)findViewById(R.id.editText_Pos);

        btnAdd=(Button)findViewById(R.id.button_Add);

        final DBAdapter db=new DBAdapter(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPEN
                db.openDB();

                //INSERT
                long result=db.add(txtName.getText().toString(), txtPos.getText().toString());

                if(result > 0)
                {
                    txtName.setText("");
                    txtPos.setText("");
                }else
                {
                    Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();
                }


                //CLOSE DB
                db.close();
            }
        });
    }//onCreate

}//AddActivity
