/*
 * Copyright (C) 2014 HIQES LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hiqes.advsensordemo;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.widget.TextView;

public class HandlerDemo extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor        mSensor;
    private Handler       mHandler;
    private HandlerThread mHandlerThread;
    private TextView      mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        mText = (TextView) findViewById(R.id.txtHandler);

        mHandlerThread = new HandlerThread("SensorThread");
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper());


        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL, mHandler);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
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

        for (float v : event.values) {
            sb.append(v);
            sb.append("\n");
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mText.setText(sb.toString());
            }
        });

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
