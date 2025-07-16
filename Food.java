/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

/**
 *
 * @author aslan
 */
public class Food {

    Point point;

    public Food(int x, int y) {
        point = new Point(x, y);
    }

    public Point getPoint() {
        return this.point;
    }

    public void setX(int x) {
        this.point.setX(x);
    }

    public int getX() {
        return this.point.getX();
    }

    public void setY(int y) {
        this.point.setY(y);
    }

    public int getY() {
        return this.point.getY();
    }

    public void setXY(int x, int y) {
        this.point.setXY(x, y);
    }
}
