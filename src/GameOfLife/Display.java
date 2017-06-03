package GameOfLife;

import javax.swing.*;
import java.awt.*;

/**
 * Created by chenrz925 on 2017/6/3.
 * 上午10:56 Project: GameOfLIfe
 *
 * @author chenrz925
 */
public class Display extends JFrame {
    private int labelSize = 0;

    Display(Map map) {
        setLayout(new CardLayout());
        setSize(800, 800);
        labelSize = 800 / map.SIZE;
        DrawPanel panel = new DrawPanel(map.SIZE);
        add(panel);
        (new Thread(()->{
            while (true) {
                boolean[][] matrix = map.nextState();
                panel.UpdateStates(matrix);
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        })).start();
        panel.setBackground(Color.gray);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Map map = new Map(80);
        map.setRandomMap();
        Display display = new Display(map);
    }
}

class DrawPanel extends JPanel {
    boolean[][] map = null;

    private int size = 0;

    DrawPanel(int size) {
        this.size = size;
    }

    public void UpdateStates(boolean[][] map) {
        this.map = map;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                g.setColor(map[i][j] ? Color.BLUE : Color.LIGHT_GRAY);
                g.fillRect(i * (800 / size), j * (800 / size), 800 / size, 800 / size);
                g.setColor(Color.BLACK);
                g.drawRect(i * (800 / size), j * (800 / size), 800 / size, 800 / size);
            }
        }
    }
}