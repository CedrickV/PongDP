package org.example.Game;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import org.example.Ball.Ball;
import org.example.Ball.NormalBallBehavior;
import org.example.Paddle.Direction;
import org.example.Paddle.Paddle;

public class Game {
    private GameState gameState;
    private AnimationTimer gameLoop;
    private List<Observer> observers = new ArrayList<>();

    public Game(GameState gameState) {
        this.gameState = gameState;
        // Initialiser l'AnimationTimer
        gameLoop = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                // Mise à jour du jeu à intervalles réguliers
                if (now - lastUpdate >= 16_000_000) { // environ 60 images par seconde
                    update();
                    lastUpdate = now;
                }
            }
        };
    }
    public void start() {
        gameLoop.start();
    }
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    // Code pour gérer les collisions de la balle avec les raquettes et les bords
    private void handleCollisions() {
        Ball ball = gameState.getBall();
        Paddle player1 = gameState.getPlayer1();
        Paddle player2 = gameState.getPlayer2();
        NormalBallBehavior behavior = (NormalBallBehavior) ball.getBehavior();

        // Collision avec les bords supérieur et inférieur
        if (ball.getY() <= 0 || ball.getY() >= 19) {
            behavior.reverseY();
        }

        // Collision avec les raquettes
        if (ball.getX() == 2 && ball.getY() >= player1.getY() && ball.getY() < player1.getY() + 6 ||
                ball.getX() == 37 && ball.getY() >= player2.getY() && ball.getY() < player2.getY() + 6) {
            behavior.reverseX();
        }

        // La balle sort de la zone de jeu (joueur 1 ou 2 marque un point)
        if (ball.getX() <= 0) {
            gameState.setPlayer2Score(gameState.getPlayer2Score() + 1);
            ball.setX(20);
            ball.setY(10);
            behavior.resetDirection();
        } else if (ball.getX() >= 39) {
            gameState.setPlayer1Score(gameState.getPlayer1Score() + 1);
            ball.setX(20);
            ball.setY(10);
            behavior.resetDirection();
        }
    }

    // Code pour déplacer les raquettes
    public void movePaddle(Direction direction, boolean isPlayer1) {
        Paddle paddle = isPlayer1 ? gameState.getPlayer1() : gameState.getPlayer2();
        int newY = direction == Direction.UP ? paddle.getY() - 1 : paddle.getY() + 1;
        // Empêcher la raquette de sortir de la zone de jeu
        if (newY >= 0 && newY <= 17) {
            paddle.setY(newY);
        }
    }


    public void update() {
        // Mettre à jour l'état du jeu
        gameState.getBall().updatePosition();
        handleCollisions();

        // Notifier les observateurs
        notifyObservers();
    }

    //getter GameState
    public GameState getGameState() {
        return gameState;
    }
}