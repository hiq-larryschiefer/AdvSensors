package com.hiqes.advsensordemo;

import android.hardware.TriggerEvent;
import android.hardware.TriggerEventListener;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by KP on 12/01/15.
 */
public class TriggerListener extends TriggerEventListener {

    private TextView txtTrigerEvent;
    public TriggerListener(TextView textView){
        this.txtTrigerEvent = textView;
    }
    @Override
    public void onTrigger(TriggerEvent event) {
        Log.i("TriggerListener", "Name:" + event.sensor.getName());
        Log.i("TriggerListener","Type:" + event.sensor.getType());

        txtTrigerEvent.setText("Name: " + event.sensor.getName() + "\nType: " + event.sensor.getType());
    }
}
