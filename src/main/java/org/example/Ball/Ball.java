package org.example.Ball;

public class Ball {
    private int x;
    private int y;
    private BallBehavior behavior;

    public Ball(int x, int y, BallBehavior behavior) {
        this.x = x;
        this.y = y;
        this.behavior = behavior;
    }

    public void updatePosition() {
        behavior.updatePosition(this);
    }

    // Getters and setters for x, y and behavior
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BallBehavior getBehavior() {
        return behavior;
    }

    public void setBehavior(BallBehavior behavior) {
        this.behavior = behavior;
    }
}
