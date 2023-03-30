package org.example.Ball;

import org.example.Ball.Ball;
import org.example.Ball.BallBehavior;

public class NormalBallBehavior implements BallBehavior {
    private int dx = -1; // Vitesse en 'X'
    private int dy = -1; // Vitesse en 'Y'

    @Override
    public void updatePosition(Ball ball) {
        int newX = ball.getX() + dx;
        int newY = ball.getY() + dy;

        ball.setX(newX);
        ball.setY(newY);
    }
    public void reverseX() {
        dx = -dx;
    }

    public void reverseY() {
        dy = -dy;
    }

    public void resetDirection() {
        dx = Math.abs(dx);
        dy = 1;
    }
}
