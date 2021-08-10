package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Browser extends AppCompatActivity {
    Button b1;
    EditText e1;
    WebView w1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        b1=(Button)findViewById(R.id.button47);
        e1=(EditText)findViewById(R.id.editTextTextPersonName12);
        w1=(WebView)findViewById(R.id.webview);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString().trim();
                w1.loadUrl(s1);
            }
        });

    }
}