package com.hiqes.advsensordemo;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by KP on 15/01/15.
 */
public class SensorService extends Service implements SensorEventListener {

    private String TAG = this.getClass().getSimpleName();
    private SensorManager sensorManager;
    private Sensor mSensor;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,mSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
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
        Log.i(TAG,sb.toString());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
