package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

public class LightSensor extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    Sensor s;
    MediaPlayer m1;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
        m1=MediaPlayer.create(this,R.raw.a);
        i1=(ImageView)findViewById(R.id.imageView);

        }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[0]>10) {
            m1.start();
            i1.setImageResource(R.drawable.u);

        }
        else {
            m1.pause();
            i1.setImageResource(R.drawable.q);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}