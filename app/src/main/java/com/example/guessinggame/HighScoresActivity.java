package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HighScoresActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        Intent intent = getIntent();
        int score = intent.getIntExtra(GameActivity.EXTRA_SCORE, 0);
        String name = intent.getStringExtra(GameActivity.EXTRA_NAME);

        TextView testOutput = (TextView)findViewById(R.id.testOutput);
        char[] message = (name + ": " + score).toCharArray();
        testOutput.setText(message, 0, message.length);
    }
}