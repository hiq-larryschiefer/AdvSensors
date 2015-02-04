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

import android.hardware.TriggerEvent;
import android.hardware.TriggerEventListener;
import android.util.Log;
import android.widget.TextView;

public class TriggerListener extends TriggerEventListener {
    private TextView mText;

    public TriggerListener(TextView textView) {
        this.mText = textView;
    }

    @Override
    public void onTrigger(TriggerEvent event) {
        Log.i("TriggerListener", "Name:" + event.sensor.getName());
        Log.i("TriggerListener", "Type:" + event.sensor.getType());

        mText.setText("Name: " + event.sensor.getName() + "\nType: " + event.sensor.getType());
    }
}
