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
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class TriggerEventDemo extends Activity {
    private SensorManager       mSensorManager;
    private TriggerListener     mListener;
    private Sensor              mSensor;
    private TextView            mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triggerdemo);
        mText = (TextView) findViewById(R.id.txtTriggerEvent);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mListener = new TriggerListener(mText);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION);
        if (mSensor == null) {
            Toast.makeText(this, R.string.sig_motion_unavailable, Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mSensor != null) {
            mSensorManager.requestTriggerSensor(mListener, mSensor);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mSensor != null) {
            mSensorManager.cancelTriggerSensor(mListener, mSensor);
        }
    }
}
