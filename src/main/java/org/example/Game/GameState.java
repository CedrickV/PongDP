package org.example.Game;

import org.example.Ball.Ball;
import org.example.Paddle.Paddle;

public class GameState {
    private Ball ball;
    private Paddle player1;
    private Paddle player2;
    private int player1Score;
    private int player2Score;

    public GameState(Ball ball, Paddle player1, Paddle player2) {
        this.ball = ball;
        this.player1 = player1;
        this.player2 = player2;
        this.player1Score = 0;
        this.player2Score = 0;
    }

    // Getters and setters for ball, player1, player2, player1Score and player2Score

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Paddle getPlayer1() {
        return player1;
    }

    public void setPlayer1(Paddle player1) {
        this.player1 = player1;
    }

    public Paddle getPlayer2() {
        return player2;
    }

    public void setPlayer2(Paddle player2) {
        this.player2 = player2;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
    }
}

