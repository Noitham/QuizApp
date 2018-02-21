package com.example.dmora.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by dmora on 20/02/2018.
 */

public class StartAppActivity extends AppCompatActivity {

    // Event listener for all buttons
    View.OnClickListener listener;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        instanciate();
        instantiateListener();
        setListeners();

    }

    public void instanciate() {
        button1 = (Button) findViewById(R.id.startAppButton);
    }

    public void instantiateListener() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                switch (v.getId()) {
                    case R.id.startAppButton:
                        callActivity();
                        break;
                }
            }
        };
    }

    public void setListeners() {
        button1.setOnClickListener(listener);
    }

    public void callActivity() {
        startActivity(new Intent(StartAppActivity.this, MainActivity.class));
    }

}
