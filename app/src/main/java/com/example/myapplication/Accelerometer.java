package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    Sensor s;
    MediaPlayer m1;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        m1=MediaPlayer.create(this,R.raw.b);
        i1=(ImageView)findViewById(R.id.imageView3);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x=event.values[0];
        float y=event.values[1];
        float z=event.values[2];
        int x1=(int)x;
        int y1=(int)y;
        int z1=(int)z;
        if(x1!=0){
            m1.start();
            i1.setImageResource(R.drawable.u);
        }
        else{
            m1.pause();
            i1.setImageResource(R.drawable.q);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}