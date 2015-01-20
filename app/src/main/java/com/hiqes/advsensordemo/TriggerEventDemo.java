package com.hiqes.advsensordemo;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by KP on 15/01/15.
 */
public class TriggerEventDemo extends Activity {
    private SensorManager sensorManager;
    private TriggerListener listener;
    private Sensor mSensor;
    private TextView txtTriggerEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triggerdemo);
        txtTriggerEvent = (TextView) findViewById(R.id.txtTriggerEvent);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        listener = new TriggerListener(txtTriggerEvent);
        mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.requestTriggerSensor(listener,mSensor);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.cancelTriggerSensor(listener,mSensor);
    }
}
