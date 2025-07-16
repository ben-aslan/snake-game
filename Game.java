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
//    public Snake[] snakes = new Snake[maxX * maxY];
    public Snake snake = new Snake();
    public Food food = new Food(10, 10);
    public String direction = "RIGHT";
    public boolean isGameOver = false;

    public Game() {

        snake.getCell(0).setX(5);
        snake.getCell(0).setY(5);
        snake.getCell(0).setX(4);
        snake.getCell(0).setY(5);
        snake.getCell(0).setX(3);
        snake.getCell(0).setY(5);
    }

    public void move() {
        if (isGameOver) {
            return;
        }

        snake.move(direction);

        //checks that snake get out of range or not
        isGameOver=snake.snakeIsOutOfRange();

        if (isGameOver) {
            return;
        }
        
        //checks that snake eat himself then gameover
        isGameOver=snake.isEatHimself();

        if (isGameOver) {
            return;
        }
        
        if (snake.getCell(0).getX() == food.getX() && snake.getCell(0).getY() == food.getY()) {
            snake.nextSnakeLength();
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
