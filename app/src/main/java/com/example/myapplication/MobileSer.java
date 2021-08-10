package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MobileSer extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_ser);
        b1=(Button)findViewById(R.id.button12);
        b2=(Button)findViewById(R.id.button18);
        b3=(Button)findViewById(R.id.button19);
        b4=(Button)findViewById(R.id.button21);
        b5=(Button)findViewById(R.id.button20);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MobileSer.this,Calling.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MobileSer.this,SMS.class);
                startActivity(i);
                finish();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MobileSer.this,TorchApp.class);
                startActivity(i);
                finish();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MobileSer.this,SensorApp.class);
                startActivity(i);
                finish();

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MobileSer.this,BluetoothApp.class);
                startActivity(i);
                finish();

            }
        });
    }
}