package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorApp extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2,b3,b4;
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_app);
        b1=(Button)findViewById(R.id.button31);
        b2=(Button)findViewById(R.id.button32);
        b3=(Button)findViewById(R.id.button33);
        b4=(Button)findViewById(R.id.button34);
        e1=(EditText)findViewById(R.id.editTextTextPersonName9);
        e2=(EditText)findViewById(R.id.editTextTextPersonName10);
        t1=(TextView)findViewById(R.id.textView10);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Float f1=Float.parseFloat(s1);
                Float f2=Float.parseFloat(s2);
                Float f3=f1+f2;
                String s3=Float.toString(f3);
                t1.setText(s3);
                Toast.makeText(CalculatorApp.this, "The result is" +s3, Toast.LENGTH_SHORT).show();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Float f1=Float.parseFloat(s1);
                Float f2=Float.parseFloat(s2);
                Float f3=f1-f2;
                String s3=Float.toString(f3);
                t1.setText(s3);
                Toast.makeText(CalculatorApp.this, "The result is" +s3, Toast.LENGTH_SHORT).show();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Float f1=Float.parseFloat(s1);
                Float f2=Float.parseFloat(s2);
                Float f3=f1*f2;
                String s3=Float.toString(f3);
                t1.setText(s3);
                Toast.makeText(CalculatorApp.this, "The result is" +s3, Toast.LENGTH_SHORT).show();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Float f1=Float.parseFloat(s1);
                Float f2=Float.parseFloat(s2);
                Float f3=f1/f2;
                String s3=Float.toString(f3);
                t1.setText(s3);
                Toast.makeText(CalculatorApp.this, "The result is" +s3, Toast.LENGTH_SHORT).show();

            }
        });
    }
}