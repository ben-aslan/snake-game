/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Aslan
 */
public class GamePanel extends JPanel {

    Game game;
    int cellSize = 20;

    public GamePanel(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(game.maxX * cellSize, game.maxY * cellSize));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (game.isGameOver) {
            g.setColor(Color.WHITE);
            g.drawString("Game Over!", 100, 100);
            return;
        }

        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i < game.maxX; i++) {
            for (int j = 0; j < game.maxY; j++) {
                g.drawRect(i * cellSize, j * cellSize, cellSize, cellSize);
            }
        }

        g.setColor(Color.GREEN);
        for (int i = 0; i < game.snake.length; i++) {
            int x = game.snake.getCell(i).getX();
            int y = game.snake.getCell(i).getY();
            g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
        }

        g.setColor(Color.RED);
        g.fillOval(game.food.getX() * cellSize, game.food.getY() * cellSize, cellSize, cellSize);
    }
}
