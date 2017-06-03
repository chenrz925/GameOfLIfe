package GameOfLife;

import javax.swing.*;
import java.awt.*;

/**
 * Created by chenrz925 on 2017/6/3.
 * 下午12:44 Project: GameOfLIfe
 *
 * @author chenrz925
 */
public class Control extends JFrame {

    Control(Map map) {
        setLayout(new GridLayout(2, 1));
        JButton startAndPause = new JButton("START");
        JSlider speed = new JSlider(1, 1000, 10);
        JPanel speedPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
        speedPane.add(new JLabel("SPEED "));
        speedPane.add(speed);
        speed.addChangeListener(e -> {
            (new Thread(() -> {
                map.sleepTime = 10000 / speed.getValue();
            })).start();
        });
        startAndPause.addActionListener(e -> {
            if (map.isPause) {
                startAndPause.setText("PAUSE");
                map.isPause = false;
            } else {
                startAndPause.setText("START");
                map.isPause = true;
            }
        });
        add(speedPane);
        add(startAndPause);
        setSize(200, 400);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }
}
