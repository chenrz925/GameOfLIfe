package GameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by chenrz925 on 2017/6/3.
 * 上午10:56 Project: GameOfLIfe
 *
 * @author chenrz925
 */
public class Display extends JFrame {

    boolean[][] matrix;

    Display(Map map) {
        setLayout(new CardLayout());
        setSize(800, 800);
        DrawPanel panel = new DrawPanel(map.SIZE);
        add(panel);
        (new Thread(() -> {
            do {
                synchronized (map.isPause) {
                    if (!map.isPause) {
                        matrix = map.nextState();
                        panel.updateStates(matrix);
                        try {
                            Thread.currentThread().sleep(map.sleepTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } while (true);
        })).start();
        panel.setBackground(Color.gray);
        panel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                (new Thread(() -> {
                    int mouseX = e.getX();
                    int mouseY = e.getY();
                    int indexX = mouseX / panel.getRectSize();
                    int indexY = mouseY / panel.getRectSize();
                    if (indexX >= 0 && indexX < map.SIZE && indexY >= 0 && indexY < map.SIZE) {
                        try {
                            map.setStateOfPoint(indexX, indexY, true);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        panel.updateStates(map.getMap());
                    }
                })).start();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        setLocation(200, 0);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class DrawPanel extends JPanel {
    private boolean[][] map = null;
    private int rectSize = 0;
    private int size = 0;
    int color = 0;
    Color[] colors = null;

    DrawPanel(int size) {
        this.size = size;
        this.rectSize = 800 / size;
        this.map = new boolean[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j)
                this.map[i][j] = false;
        }
        colors = new Color[5];
        colors[0] = Color.RED;
        colors[1] = Color.ORANGE;
        colors[2] = Color.GREEN;
        colors[3] = Color.YELLOW;
        colors[4] = Color.BLUE;
        int color = (int) (Math.random() % 5);
    }

    public int getRectSize() {
        return rectSize;
    }

    public void updateStates(boolean[][] map) {
        this.map = map;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                g.setColor(map[i][j] ? colors[color % 5] : Color.LIGHT_GRAY);
                g.fillRect(i * (rectSize), j * (rectSize), rectSize, rectSize);
                g.setColor(Color.BLACK);
                g.drawRect(i * (rectSize), j * (rectSize), rectSize, rectSize);
            }
        }
        color++;
    }
}