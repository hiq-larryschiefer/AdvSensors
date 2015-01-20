package com.hiqes.advsensordemo;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.widget.TextView;

/**
 * Created by KP on 15/01/15.
 */
public class HandlerDemo extends Activity implements SensorEventListener{
    private SensorManager sensorManager;
    private Sensor mSensor;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private TextView txtHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        txtHandler  = (TextView) findViewById(R.id.txtHandler);

        mHandlerThread = new HandlerThread("SensorThread");
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper());


        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }


    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL, mHandler);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Sensor Name: ");
        sb.append(event.sensor.getName());
        sb.append("\n");
        sb.append("Time: ");
        sb.append(event.timestamp);
        sb.append("\n");
        sb.append("Accuracy: ");
        sb.append(event.accuracy);
        sb.append("\n");

        for(float v : event.values){
            sb.append(v);
            sb.append("\n");
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                   txtHandler.setText(sb.toString());
            }
        });

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
