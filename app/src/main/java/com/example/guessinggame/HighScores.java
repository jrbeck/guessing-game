package com.example.guessinggame;

import java.util.ArrayList;

public class HighScores {
    public class Score {
        int mValue;
        String mPlayerName;
    }

    private ArrayList<Score> mScores;

    public void addScore(int value, String playerName) {
        Score score = new Score();
        score.mValue = value;
        score.mPlayerName = playerName;
        mScores.add(score);
    }
}
