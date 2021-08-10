package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class Calling extends AppCompatActivity {
    ImageButton ib;
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);
        e1=(EditText)findViewById(R.id.editTextTextPersonName6);
        ib=(ImageButton)findViewById(R.id.imageButton5);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                try {
                    Intent i = new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:" + s1));
                    startActivity(i);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                }
        });


    }
}