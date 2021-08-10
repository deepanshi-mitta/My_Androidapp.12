package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TorchApp extends AppCompatActivity {
    Button b1,b2;
    private boolean torch=false;
    CameraManager cm;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch_app);
        b1=(Button)findViewById(R.id.button16);
        b2=(Button)findViewById(R.id.button17);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                try{
                    String id=cm.getCameraIdList()[0];
                    cm.setTorchMode(id,true);
                    torch=true;
                }
                catch(CameraAccessException ca){

                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                try{
                    String id=cm.getCameraIdList()[0];
                    cm.setTorchMode(id,false);
                    torch=false;
                }
                catch(CameraAccessException ca){

                }

            }
        });


    }
}