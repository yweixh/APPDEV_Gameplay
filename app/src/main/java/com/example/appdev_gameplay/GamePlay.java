package com.example.appdev_gameplay;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GamePlay extends AppCompatActivity implements View.OnClickListener{

    TextView questionTotal, timer, score, wordToGuess;
    Button first, second, third, fourth;

    int currentScore = 0;
    int totalQuestion = QuestionAnswerz.question.length;
    int currentQuestionIndex = 0;
    int currentTime = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        wordToGuess = findViewById(R.id.WordToGuess);
        questionTotal = findViewById(R.id.QuestionNumber);
        timer = findViewById(R.id.TimeNumber);
        score = findViewById(R.id.ScoreNumber);
        first = findViewById(R.id.FirstChoice);
        second = findViewById(R.id.SecondChoice);
        third = findViewById(R.id.ThirdChoice);
        fourth = findViewById(R.id.FourthChoice);

        //For choice buttons
        first.setOnClickListener(this);
        second.setOnClickListener(this);
        third.setOnClickListener(this);
        fourth.setOnClickListener(this);

        questionTotal.setText(totalQuestion);
        loadNewQuestion();

    }

    private void loadNewQuestion() {
        if(currentQuestionIndex == totalQuestion) {
            finish();
            return;
        }

        questionTotal.setText(QuestionAnswerz.question[currentQuestionIndex]);
        first.setText(QuestionAnswerz.choices[currentQuestionIndex][0]);
        second.setText(QuestionAnswerz.choices[currentQuestionIndex][1]);
        third.setText(QuestionAnswerz.choices[currentQuestionIndex][2]);
        fourth.setText(QuestionAnswerz.choices[currentQuestionIndex][3]);
    }

    @Override
    public void onClick(View view) {
        Button buttonClicked = (Button) view;
        if(buttonClicked.getId()==R.id.FirstChoice) {
            currentQuestionIndex++;
            loadNewQuestion();
            if (selectedAnswer.equals(QuestionAnswerz.answers[currentQuestionIndex])) {
                currentScore++;
            }
        } else if (buttonClicked.getId()==R.id.SecondChoice) {
            currentQuestionIndex++;
            loadNewQuestion();
            if (selectedAnswer.equals(QuestionAnswerz.answers[currentQuestionIndex])) {
                currentScore++;
            }
        } else if (buttonClicked.getId()==R.id.ThirdChoice) {
            currentQuestionIndex++;
            loadNewQuestion();
            if (selectedAnswer.equals(QuestionAnswerz.answers[currentQuestionIndex])) {
                currentScore++;
            }
        } else if (buttonClicked.getId()==R.id.FourthChoice) {
            currentQuestionIndex++;
            loadNewQuestion();
            if (selectedAnswer.equals(QuestionAnswerz.answers[currentQuestionIndex])) {
                currentScore++;
            }
        } else {
            selectedAnswer = buttonClicked.getText().toString();
            buttonClicked.setBackgroundColor(Color.GREEN);
            loadNewQuestion();
        }

    }
}