package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    public static final String EXTRA_SCORE = "com.example.guessinggame.SCORE";
    public static final String EXTRA_NAME = "com.example.guessinggame.NAME";

    private int mSecretNumber = new Random().nextInt(100) + 1;
    private int mScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void submitGuess(View view) {
        mScore++;
        EditText guessInput = (EditText)findViewById(R.id.editTextNumber);
        String guessString = guessInput.getText().toString();
        if (guessString.equals("")) {
            // problem
            return;
        }
        int guess = Integer.parseInt(guessString);
        TextView feedbackText = (TextView)findViewById(R.id.feedbackText);
        if (guess > mSecretNumber) {
            feedbackText.setText(R.string.guess_too_high);
            return;
        }
        else if (guess < mSecretNumber) {
            feedbackText.setText(R.string.guess_too_low);
            return;
        }

        feedbackText.setText(R.string.guess_correct);
        View nameText = findViewById(R.id.playerName);
        nameText.setVisibility(View.VISIBLE);

        View endGameButton = findViewById(R.id.endGameButton);
        endGameButton.setVisibility(View.VISIBLE);
    }

    public void endGame(View view) {
        EditText nameText = (EditText)findViewById(R.id.playerName);
        String playerName = nameText.getText().toString();

        if (playerName.equals("")) {
            // bad player!!!
            return;
        }

        Intent intent = new Intent(this, HighScoresActivity.class);
        intent.putExtra(EXTRA_SCORE, mScore);
        intent.putExtra(EXTRA_NAME, playerName);
        startActivity(intent);
    }
}