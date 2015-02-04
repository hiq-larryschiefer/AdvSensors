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

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void buttonClicked(View view) {
        if (view.getId() == R.id.btnHandlerDemo) {
            startActivity(new Intent(this, HandlerDemo.class));
        } else if (view.getId() == R.id.btnServiceDemo) {
            startActivity(new Intent(this, ServiceDemo.class));
        } else if (view.getId() == R.id.btnTriggerDemo) {
            startActivity(new Intent(this, TriggerEventDemo.class));
        }
    }
}
