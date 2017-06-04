package GameOfLife;

import javax.swing.*;

/**
 * Created by chenrz925 on 2017/6/3.
 * 下午1:21 Project: GameOfLIfe
 *
 * @author chenrz925
 */
public class Main {
    public static void main(String[] args) {
        int size = 80;
        int choice = 0;
        if (args.length > 0) {
            try {
                choice = Integer.parseInt(args[0]);
            } catch (NumberFormatException ne) {
                try {
                    choice = Integer.parseInt(JOptionPane.showInputDialog("Input the size of map: \n1-10x10\n2-20x20\n3-40x40\n4-80x80\n5-160x160\nWrong input-80x80\n"));
                } catch (NumberFormatException innerNE) {
                    choice = 4;
                }
            }
        } else {
            try {
                choice = Integer.parseInt(JOptionPane.showInputDialog("Input the size of map: \n1-10x10\n2-20x20\n3-40x40\n4-80x80\n5-160x160\nWrong input-80x80\n"));
            } catch (NumberFormatException innerNE) {
                choice = 4;
            }
        }
        switch (choice) {
            case 1:
                size = 10;
                break;
            case 2:
                size = 20;
                break;
            case 3:
                size = 40;
                break;
            case 4:
                size = 80;
                break;
            case 5:
                size = 160;
                break;
            default:
                size = 80;
                break;
        }
        Map map = new Map(size);
        Display display = new Display(map);
        Control control = new Control(map);
        display.setVisible(true);
        control.setVisible(true);
        System.out.println("Map size: " + size);
    }
}
