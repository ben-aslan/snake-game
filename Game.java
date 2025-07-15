/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

/**
 *
 * @author Aslan
 */
public class Game {

    public int maxX = 30, maxY = 30;
//    public int[][] snake = new int[100][2]; // each element is [x, y]
    public Snake[] snakes = new Snake[maxX * maxY];
    public int length = 3;
    public Point food = new Point(10, 10);
    public String direction = "RIGHT";
    public boolean isGameOver = false;

    public Game() {
        for (int i = 0; i < snakes.length; i++) {
            snakes[i] = new Snake();
        }

        snakes[0].setX(5);
        snakes[0].setY(5);
        snakes[0].setX(4);
        snakes[0].setY(5);
        snakes[0].setX(3);
        snakes[0].setY(5);
    }

    public void move() {
        if (isGameOver) {
            return;
        }

        for (int i = length - 1; i > 0; i--) {
            snakes[i].setX(snakes[i - 1].getX());
            snakes[i].setY(snakes[i - 1].getY());
        }

        switch (direction) {
            case "UP":
                snakes[0].setY(snakes[0].getY() - 1);
                break;
            case "DOWN":
                snakes[0].setY(snakes[0].getY() + 1);
                break;
            case "LEFT":
                snakes[0].setX(snakes[0].getX() - 1);
                break;
            case "RIGHT":
                snakes[0].setX(snakes[0].getX() + 1);
                break;
        }

        //checks that snake get out of range or not
        if (snakes[0].getX() < 0 || snakes[0].getX() >= maxX || snakes[0].getY() < 0 || snakes[0].getY() >= maxY) {
            isGameOver = true;
        }

        //checks that snake eat himself then gameover
        for (int i = 1; i < length; i++) {
            if (snakes[0].getX() == snakes[i].getX() && snakes[0].getY() == snakes[i].getY()) {
                isGameOver = true;
                return;
            }
        }

        if (snakes[0].getX() == food.getX() && snakes[0].getY() == food.getY()) {
            length++;
            food.setX((int) (Math.random() * maxX));
            food.setY((int) (Math.random() * maxY));
        }
    }

    public void setDirection(String dir) {
        if ((dir.equals("UP") && direction.equals("DOWN"))
                || (dir.equals("DOWN") && direction.equals("UP"))
                || (dir.equals("LEFT") && direction.equals("RIGHT"))
                || (dir.equals("RIGHT") && direction.equals("LEFT"))) {
            return;
        }

        direction = dir;
    }
}
