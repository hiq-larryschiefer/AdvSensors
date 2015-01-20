package com.hiqes.advsensordemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by KP on 15/01/15.
 */
public class ServiceDemo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }
    public void buttonClicked(View v){
        if(v.getId() == R.id.btnStartService){
            startService(new Intent(this,SensorService.class));
        }
        else if(v.getId() == R.id.btnStopService){
            stopService(new Intent(this,SensorService.class));
        }
    }
}
