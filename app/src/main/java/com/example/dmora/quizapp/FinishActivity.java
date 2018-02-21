package com.example.dmora.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by dmora on 20/02/2018.
 */

public class FinishActivity extends AppCompatActivity {

    //We declare the variables
    public String score;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        name = bundle.getString("name");
        score = bundle.getString("result");
        setResult();

    }

    //We show the collected result from MainActivity to the user
    private void setResult() {
        TextView resultText = findViewById(R.id.result);
        TextView scoreResult = findViewById(R.id.score);
        String Msg = name + ", this is your result";
        resultText.setText(Msg);

        String resultMsg = MainActivity.points + "/5";
        scoreResult.setText(resultMsg);
    }

    //Exit method
    public void exit(View view) {
        ActivityCompat.finishAffinity(this);
    }

    //In case users presses "Try Again" button, we will show MainActivity again, with cleared on result/name.
    public void tryAgain(View view) {
        TextView resultText = findViewById(R.id.result);
        TextView scoreResult = findViewById(R.id.score);

        MainActivity.points = 0;
        resultText.setText(" ");
        scoreResult.setText(" ");

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", "");
        intent.putExtra("result", 0);
        startActivity(intent);
    }


}
