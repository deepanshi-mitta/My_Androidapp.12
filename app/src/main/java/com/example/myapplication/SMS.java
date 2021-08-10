package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMS extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    SmsManager sm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        e1 = (EditText) findViewById(R.id.editTextTextPersonName7);
        e2 = (EditText) findViewById(R.id.editTextTextPersonName8);
        b1 = (Button) findViewById(R.id.button22);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();


                try {
                    // Get the default instance of the SmsManager
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(s1,
                            null,
                            s2,
                            null,
                            null);
                    Toast.makeText(getApplicationContext(), "Your sms has successfully sent!",
                            Toast.LENGTH_LONG).show();
                    Uri uri = Uri.parse("smsto:" + s1);
                    Intent i=new Intent(Intent.ACTION_SENDTO,uri);
                    startActivity(i);
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(),"Your sms has failed...",
                            Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            }


        });

    }
}