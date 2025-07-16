/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

/**
 *
 * @author Aslan
 */
public class Snake {

    public int length = 3;

    public int maxX = 30, maxY = 30;

    public SnakeCell[] snakeCells = new SnakeCell[maxX * maxY];

    public Snake() {
        for (int i = 0; i < snakeCells.length; i++) {
            snakeCells[i] = new SnakeCell();
        }
    }

    public SnakeCell getCell(int index) {
        return this.snakeCells[index];
    }

    public void move(String direction) {
        for (int i = length - 1; i > 0; i--) {
            getCell(i).setX(getCell(i - 1).getX());
            getCell(i).setY(getCell(i - 1).getY());
        }

        switch (direction) {
            case "UP":
                getCell(0).setY(getCell(0).getY() - 1);
                break;
            case "DOWN":
                getCell(0).setY(getCell(0).getY() + 1);
                break;
            case "LEFT":
                getCell(0).setX(getCell(0).getX() - 1);
                break;
            case "RIGHT":
                getCell(0).setX(getCell(0).getX() + 1);
                break;
        }
    }

    public boolean isEatHimself() {
        for (int i = 1; i < length; i++) {
            if (getCell(0).getX() == getCell(i).getX() && getCell(0).getY() == getCell(i).getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean snakeIsOutOfRange() {
        if (getCell(0).getX() < 0 || getCell(0).getX() >= maxX || getCell(0).getY() < 0 || getCell(0).getY() >= maxY) {
            return true;
        }
        return false;
    }

    public void nextSnakeLength() {
        length++;
    }
}
