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
        setLayout(new GridLayout(3, 1));
        JButton startAndPause = new JButton("START");
        JPanel startAndPausePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        startAndPausePane.add(startAndPause);
        JSlider speed = new JSlider(1, 500, 10);
        JPanel speedPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel speedText = new JLabel();
        speedPane.add(new JLabel("SPEED "));
        speedPane.add(speed);
        speedPane.add(speedText);
        speedText.setText(speed.getValue() + "");
        speed.addChangeListener(e -> {
            (new Thread(() -> {
                map.sleepTime = 10000 / speed.getValue();
                speedText.setText(speed.getValue() + "");
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
        JPanel resetPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton reset = new JButton("RESET");
        reset.addActionListener(e -> {
            for (int i = 0; i < map.SIZE; ++i) {
                for (int j = 0; j < map.SIZE; ++j)
                    try {
                        map.setStateOfPoint(i, j, false);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
            }
            map.isEmpty=true;
        });
        resetPane.add(reset);
        add(speedPane);
        add(startAndPausePane);
        add(resetPane);
        setSize(200, 400);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
}
