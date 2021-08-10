package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginOptions extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_options);
        b1=(Button)findViewById(R.id.button8);
        b2=(Button)findViewById(R.id.button9);
        e1=(EditText)findViewById(R.id.editTextTextPersonName);
        e2=(EditText)findViewById(R.id.editTextTextPersonName2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginOptions.this,LoginOptions2.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("")|| s2.equals("")){
                    Toast.makeText(LoginOptions.this, "Plzz fill all", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase sql=openOrCreateDatabase("gla",MODE_PRIVATE,null);
                    sql.execSQL("create table if not exists student (name varchar,email varchar,password varchar)");
                    String s3="select * from student where name='"+s1+"' and email='"+s2+"'";
                    Cursor c1=sql.rawQuery(s3,null);
                    if(c1.getCount()>0){
                        Intent i=new Intent(LoginOptions.this,OfflineScreen.class);
                        startActivity(i);
                        finish();
                    }
                    else{
                        Toast.makeText(LoginOptions.this, "Wrong credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}