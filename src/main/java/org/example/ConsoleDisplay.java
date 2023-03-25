package org.example;

public class ConsoleDisplay implements Observer {
    private static ConsoleDisplay instance;
    private GameState gameState;

    private ConsoleDisplay(GameState gameState) {
        this.gameState = gameState;
    }

    public static ConsoleDisplay getInstance(GameState gameState) {
        if (instance == null) {
            instance = new ConsoleDisplay(gameState);
        }
        return instance;
    }

    public void render() {
        int width = 40; // Largeur de la zone de jeu
        int height = 20; // Hauteur de la zone de jeu

        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == gameState.getBall().getX() && y == gameState.getBall().getY()) {
                    sb.append('O'); // Afficher la balle
                } else if (x == 1 && y >= gameState.getPlayer1().getY() && y < gameState.getPlayer1().getY() + 3) {
                    sb.append('|'); // Afficher la raquette du joueur 1
                } else if (x == width - 2 && y >= gameState.getPlayer2().getY() && y < gameState.getPlayer2().getY() + 3) {
                    sb.append('|'); // Afficher la raquette du joueur 2
                } else {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }

        // Nettoyer la console avant d'afficher l'état du jeu
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Afficher l'état du jeu
        System.out.println(sb.toString());
    }

    @Override
    public void update() {
        render();
    }
}
