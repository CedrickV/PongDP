package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.Ball.Ball;
import org.example.Ball.NormalBallBehavior;
import org.example.Game.Game;
import org.example.Game.GameState;
import org.example.Game.JavaFXDisplay;
import org.example.Paddle.Direction;
import org.example.Paddle.Paddle;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Créer les objets du jeu
        Ball ball = new Ball(0, 0, new NormalBallBehavior());
        Paddle player1 = new Paddle(10);
        Paddle player2 = new Paddle(10);
        GameState gameState = new GameState(ball, player1, player2);
        Game game = new Game(gameState);

        // Créer l'affichage JavaFX
        JavaFXDisplay javaFXDisplay = new JavaFXDisplay(gameState);
        game.addObserver(javaFXDisplay);

        // Créer la scène
        Pane root = javaFXDisplay.getRoot();
        Scene scene = new Scene(root, 800, 400);

        // Gérer les entrées clavier pour les mouvements des raquettes
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W:
                    game.movePaddle(Direction.UP, true);
                    break;
                case S:
                    game.movePaddle(Direction.DOWN, true);
                    break;
                case O:
                    game.movePaddle(Direction.UP, false);
                    break;
                case L:
                    game.movePaddle(Direction.DOWN, false);
                    break;
            }
        });

        // Configurer et afficher la fenêtre principale
        primaryStage.setTitle("Pong");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Lancer le jeu
        game.start();
    }
}

