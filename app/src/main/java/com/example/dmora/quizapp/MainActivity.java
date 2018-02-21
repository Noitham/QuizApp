package com.example.dmora.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //We declare variables.

    public static int points = 0;
    public static String name;

    EditText nameText;

    RadioGroup radioGroup1, radioGroup2;

    RadioButton question1, question2, question4, question5;

    CheckBox answer1, answer2, answer3, answer4;
    //We create 2 listeners for the Radiogroups on question 4. This will make the two Radiogroups work as one.
    private RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                radioGroup1.setOnCheckedChangeListener(null); // remove the listener before clearing.
                radioGroup1.clearCheck(); // clear the first RadioGroup!
                radioGroup1.setOnCheckedChangeListener(listener1); //reset the listener.
            }
        }
    };
    private RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                radioGroup2.setOnCheckedChangeListener(null); // remove the listener before clearing.
                radioGroup2.clearCheck(); // clear the second RadioGroup!
                radioGroup2.setOnCheckedChangeListener(listener2); //reset the listener.
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        radioGroup1.clearCheck(); // this is so we can start fresh, with no selection.
        radioGroup2.clearCheck();

        radioGroup1.setOnCheckedChangeListener(listener1);
        radioGroup2.setOnCheckedChangeListener(listener2);
    }

    //Here we set the our variables
    public void initialize() {

        nameText = (EditText) findViewById(R.id.name_text);

        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);

        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);

        question1 = (RadioButton) findViewById(R.id.question1_2choice);
        question2 = (RadioButton) findViewById(R.id.question2_3choice);
        question4 = (RadioButton) findViewById(R.id.question4_1choice);
        question5 = (RadioButton) findViewById(R.id.question5_3choice);

        answer1 = (CheckBox) findViewById(R.id.question3_1choice);
        answer2 = (CheckBox) findViewById(R.id.question3_2choice);
        answer3 = (CheckBox) findViewById(R.id.question3_3choice);
        answer4 = (CheckBox) findViewById(R.id.question3_4choice);

    }

    //Method we will calculate the result, by adding 1 point to our points variable if the correct RadioButton/CheckBoxes is checked on each question.
    public int calculateResult() {

        if (question1.isChecked()) {
            points = points + 1;
        }

        if (question2.isChecked()) {
            points = points + 1;
        }

        if (question4.isChecked()) {
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

    //Finally, we create this method, which will be called once press the "Send Quiz" button.
    //The method will create an intent with the data collected from this activity (name and score), and send us
    //to the FinishActivity layout.
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
