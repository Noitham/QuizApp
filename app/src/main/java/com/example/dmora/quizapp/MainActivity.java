package com.example.dmora.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int points = 0;
    public static String name;

    EditText nameText;

    RadioButton question1, question2, question3, question5;

    CheckBox answer1, answer2, answer3, answer4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instanciate();
    }

    public void instanciate() {

        nameText = (EditText) findViewById(R.id.name_text);

        question1 = (RadioButton) findViewById(R.id.question1_2choice);
        question2 = (RadioButton) findViewById(R.id.question2_1choice);
        question3 = (RadioButton) findViewById(R.id.question4_1choice);
        question5 = (RadioButton) findViewById(R.id.question5_3choice);

        answer1 = (CheckBox) findViewById(R.id.question3_1choice);
        answer2 = (CheckBox) findViewById(R.id.question3_2choice);
        answer3 = (CheckBox) findViewById(R.id.question3_3choice);
        answer4 = (CheckBox) findViewById(R.id.question3_4choice);

    }

    public int calculateResult() {

        if (question1.isChecked()) {
            points = points + 1;
        }

        if (question2.isChecked()) {
            points = points + 1;
        }

        if (question3.isChecked()) {
            points = points + 1;
        }

        if (question5.isChecked()) {
            points = points + 1;
        }

        if ((answer1.isChecked() && answer2.isChecked()) && (!answer3.isChecked() && !answer4.isChecked())) {
            points = points + 1;
        }

        return points;

    }


    public void checkQuiz(View view) {
        int result = calculateResult();

        name = nameText.getText().toString();

        if (name.isEmpty()) {
            Toast.makeText(this, "Please, provide a name first", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, FinishActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("result", result);
            startActivity(intent);
        }


    }


}
