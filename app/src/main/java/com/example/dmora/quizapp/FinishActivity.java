package com.example.dmora.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dmora on 20/02/2018.
 */

public class FinishActivity extends AppCompatActivity{

    private String name;
    public String score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        name = bundle.getString("name");
        score =  bundle.getString("result");
        setResult();

    }

    private void setResult()
    {
        TextView resultText = findViewById(R.id.result);
        TextView scoreResult = findViewById(R.id.score);
        if(MainActivity.points >= 5) {
            String winMsg = "You win" + " " + name;
            resultText.setText(winMsg);
        }
        else if (MainActivity.points < 5)
        {
            String loseMsg = "You win" + " " + name;
            resultText.setText(loseMsg);
        }

        String resultMsg = MainActivity.points + "/10";
        scoreResult.setText(resultMsg);
    }

    public void exit(View view)
    {

    }

    public void tryAgain(View view)
    {
        TextView resultText = findViewById(R.id.result);
        TextView scoreResult = findViewById(R.id.score);

        name = " ";
        MainActivity.points = 0;
        resultText.setText(" ");
        scoreResult.setText(" ");

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name","");
        intent.putExtra("name",name);
        startActivity(intent);
    }


}
