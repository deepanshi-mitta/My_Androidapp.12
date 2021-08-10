package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalDashboard extends AppCompatActivity {
    TextView t1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_dashboard);

        t1=(TextView)findViewById(R.id.textView22);
        b1=(Button)findViewById(R.id.button51);
        t1.setText("The result is"+QuizApp.score);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(FinalDashboard.this,QuizApp.class);
                startActivity(i);
                finish();
            }
        });
    }
}