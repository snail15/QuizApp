package com.example.android.quizonkorea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String notPerfectScoreMessage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateFinalGrade(){

        boolean first = gradeFirstQ();
        boolean second = gradeSecondQ();
        boolean third = gradeThirdQ();
        boolean fourth = gradeFourthQ();
        boolean fifth = gradeFifthQ();

        if(first == true && second == true && third == true && fourth == true && fifth == true) {
            Toast.makeText(this, "You got a perfect score. Good job!!",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "You got " + notPerfectScoreMessage + "wrong. Try again!",Toast.LENGTH_SHORT).show();
        }


    }

    private boolean gradeFirstQ(){
        String correctAnswer = "korea";
        EditText answerField = (EditText) findViewById(R.id.first_answer_field);
        String userAnswer = answerField.getText().toString().toLowerCase();
        if (userAnswer.equals(correctAnswer)){
            return true;
        }
        else{
            notPerfectScoreMessage += "Q1 ";
            return false;
        }

    }

    private boolean gradeSecondQ(){
        RadioButton answer = (RadioButton) findViewById(R.id.choice_seoul);
        if(answer.isChecked()) {
            return true;
        }
        else{
            notPerfectScoreMessage +="Q2 ";
            return false;
        }
    }

    private boolean gradeThirdQ(){
        CheckBox chicago = (CheckBox) findViewById(R.id.check_chicago);
        CheckBox lisbon = (CheckBox) findViewById(R.id.check_lisbon);
        CheckBox toronto = (CheckBox)findViewById(R.id.check_toronto);

        if (chicago.isChecked() && lisbon.isChecked() && toronto.isChecked())
        {
            return true;
        }
        else {
            notPerfectScoreMessage += "Q3 ";
            return false;
        }
    }

    private boolean gradeFourthQ() {
        RadioButton yes = (RadioButton) findViewById(R.id.choice_yes);

        if (yes.isChecked()) {
            return true;
        }
        else {
            notPerfectScoreMessage += "Q4 ";
            return false;
        }
    }

    private boolean gradeFifthQ() {
        RadioButton jung = (RadioButton) findViewById(R.id.choice_jung);

        if(jung.isChecked()) {
            return true;
        }
        else {
            notPerfectScoreMessage += "Q5 ";
            return false;
        }
    }


}
