package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

public class GoogleLogin2 extends AppCompatActivity {
    ImageView i1;
    TextView textView;
    Button b1;
    GoogleSignInClient googleSignInClient;
    FirebaseAuth fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_login2);
        i1=(ImageView)findViewById(R.id.imageView5);
        b1=(Button)findViewById(R.id.button39);
        textView=(TextView)findViewById(R.id.textView14);
        fa=FirebaseAuth.getInstance();
        googleSignInClient= GoogleSignIn.getClient(GoogleLogin2.this, GoogleSignInOptions.DEFAULT_SIGN_IN);
        FirebaseUser firebaseUser=fa.getCurrentUser();
        if(firebaseUser!=null){
            Glide.with(GoogleLogin2.this).load(firebaseUser.getPhotoUrl()).into(i1);
            textView.setText(firebaseUser.getDisplayName());
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        if(task.isSuccessful()){
                            fa.signOut();
                            Toast.makeText(GoogleLogin2.this, "sign out", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(GoogleLogin2.this,WelcomePage.class);
                            startActivity(i);
                            finish();
                        }
                    }
                });
            }
        });
    }
}