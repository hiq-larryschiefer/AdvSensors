package com.hiqes.advsensordemo;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void buttonClicked(View view){
        if(view.getId() == R.id.btnHandlerDemo){
            startActivity(new Intent(this,HandlerDemo.class));
        }
        else if(view.getId() == R.id.btnServiceDemo){
            startActivity(new Intent(this,ServiceDemo.class));
        }
        else if(view.getId() == R.id.btnTriggerDemo){
            startActivity(new Intent(this,TriggerEventDemo.class));
        }
    }
}
