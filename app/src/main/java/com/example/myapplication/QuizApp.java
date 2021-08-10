package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class QuizApp extends AppCompatActivity {
    Button b1;
    RadioButton r1,r2,r3,r4;
    static int score=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_app);
        b1=(Button)findViewById(R.id.button48);
        r1=(RadioButton)findViewById(R.id.radioButton);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        r3=(RadioButton)findViewById(R.id.radioButton3);
        r4=(RadioButton)findViewById(R.id.radioButton4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score=0;
                if(r1.isChecked()){
                    ++score;
                }
                else{
                    --score;
                }
                Intent i=new Intent(QuizApp.this,QuestionSecond.class);
                startActivity(i);
                finish();

            }
        });

    }
}