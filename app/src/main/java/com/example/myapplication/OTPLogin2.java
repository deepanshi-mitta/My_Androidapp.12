package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class OTPLogin2 extends AppCompatActivity {
    EditText e1;
    Button b1;
    String phone;
    String otp;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otplogin2);
        phone= getIntent().getStringExtra("mobile").toString();
        e1=(EditText)findViewById(R.id.editTextTextPersonName26);
        b1=(Button)findViewById(R.id.button55);
        firebaseAuth=FirebaseAuth.getInstance();
        genotp();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().isEmpty()){
                    Toast.makeText(OTPLogin2.this, "Plzzz Enter OTP", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(e1.getText().toString().length()!=6){
                        Toast.makeText(OTPLogin2.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(otp,e1.getText().toString());
                        signInWithPhoneAuthcredential(credential);
                    }
                }
            }
        });

    }private void genotp(){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                    @Override
                    public void onCodeSent(@NonNull @NotNull String s, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otp=s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull @NotNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthcredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull @NotNull FirebaseException e) {
                        Toast.makeText(OTPLogin2.this, "otp mismatched", Toast.LENGTH_SHORT).show();
                    }
                }

        );
    }private void signInWithPhoneAuthcredential(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent i=new Intent(OTPLogin2.this,WelcomePage.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(OTPLogin2.this, "Login Done", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(OTPLogin2.this, "nt done", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}