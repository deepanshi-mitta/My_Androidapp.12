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

public class LoginOptions2 extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_options2);
        b1=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button10);
        e1=(EditText)findViewById(R.id.editTextTextPersonName3);
        e2=(EditText)findViewById(R.id.editTextTextPersonName4);
        e3=(EditText)findViewById(R.id.editTextTextPersonName5);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginOptions2.this,LoginOptions.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                if(s1.equals("")|| s2.equals("")||s3.equals("")){
                    Toast.makeText(LoginOptions2.this, "Plzz fill all", Toast.LENGTH_SHORT).show();
                }
                else{

                    SQLiteDatabase sql=openOrCreateDatabase("gla",MODE_PRIVATE,null);
                    sql.execSQL("create table if not exists student (name varchar,email varchar,password varchar)");
                    String s4="select * from student where name='"+s1+"' and email='"+s2+"'";
                    Cursor c1=sql.rawQuery(s4,null);
                    if(c1.getCount()>0){
                        Toast.makeText(LoginOptions2.this, "Already registered", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        sql.execSQL("insert into student values ('"+s1+"','"+s2+"','"+s3+"')");
                        Toast.makeText(LoginOptions2.this, "Registration Done", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(LoginOptions2.this,LoginOptions.class);
                        startActivity(i);
                        finish();
                    }
                }

            }
        });

    }
}