package com.example.lab1_ex3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_Ex3 extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer, mGiro, mIllum;
    private TextView textX, textY, textZ, g1, g2, g3, i1;
    private Button locationButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mGiro = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mIllum = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ex3);

        textX = findViewById(R.id.textX);
        textY = findViewById(R.id.textY);
        textZ = findViewById(R.id.textZ);
        g1 = findViewById(R.id.g1);
        g2 = findViewById(R.id.g2);
        g3 = findViewById(R.id.g3);
        i1 = findViewById(R.id.i1);
        locationButt = findViewById(R.id.gpsButt);

        locationButt = (Button) findViewById(R.id.gpsButt);
        ActivityCompat.requestPermissions(MainActivity_Ex3.this, new
                String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        locationButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPSTracker g = new GPSTracker(getApplicationContext());
                Location l = g.getLocation();
                if(l!=null)
                {
                    double lat = l.getLatitude();
                    double longi = l.getLongitude();
                    Toast.makeText(getApplicationContext(), "LAT: "+lat + "LONG: " +
                            longi, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mGiro, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mIllum, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event){
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            textX.setText(String.valueOf(event.values[0]));
            textY.setText(String.valueOf(event.values[1]));
            textZ.setText(String.valueOf(event.values[2]));
            if(event.values[0] > 20.0 || event.values[1] > 20.0 || event.values[2] > 20.0){
                Intent intent = new Intent(this, SubActivity_Ex3.class);
                startActivity(intent);
            }
        }

        if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE){
            g1.setText(String.valueOf(event.values[0]));
            g2.setText(String.valueOf(event.values[1]));
            g3.setText(String.valueOf(event.values[2]));
        }

        if(event.sensor.getType() == Sensor.TYPE_LIGHT){
            i1.setText(String.valueOf(event.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }

}