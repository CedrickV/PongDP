package org.example;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class JavaFXDisplay implements Observer {
    private GameState gameState;
    private Pane root;
    private Circle ballCircle;
    private Rectangle paddle1Rect;
    private Rectangle paddle2Rect;

    public JavaFXDisplay(GameState gameState) {
        this.gameState = gameState;
        createContent();
    }

    private void createContent() {
        root = new Pane();

        // Créer les éléments visuels pour la balle et les raquettes
        ballCircle = new Circle(5);
        paddle1Rect = new Rectangle(10, 30);
        paddle2Rect = new Rectangle(10, 30);

        // Ajouter les éléments visuels à la scène
        root.getChildren().addAll(ballCircle, paddle1Rect, paddle2Rect);
    }

    public Pane getRoot() {
        return root;
    }

    @Override
    public void update() {
        // Mettre à jour la position des éléments visuels en fonction de l'état du jeu
        Ball ball = gameState.getBall();
        ballCircle.setCenterX(ball.getX() * 20);
        ballCircle.setCenterY(ball.getY() * 20);

        Paddle player1 = gameState.getPlayer1();
        paddle1Rect.setX(20);
        paddle1Rect.setY(player1.getY() * 20);

        Paddle player2 = gameState.getPlayer2();
        paddle2Rect.setX(760);
        paddle2Rect.setY(player2.getY() * 20);
    }
}

