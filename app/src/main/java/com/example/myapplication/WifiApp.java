package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WifiApp extends AppCompatActivity {
    Button b1,b2;
    WifiManager w1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_app);
        b1=(Button)findViewById(R.id.button45);
        b2=(Button)findViewById(R.id.button46);
        w1=(WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w1.setWifiEnabled(true);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w1.setWifiEnabled(false);
            }
        });
    }
}