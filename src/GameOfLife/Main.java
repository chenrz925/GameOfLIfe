package GameOfLife;

/**
 * Created by chenrz925 on 2017/6/3.
 * 下午1:21 Project: GameOfLIfe
 *
 * @author chenrz925
 */
public class Main {
    public static void main(String[] args) {
        int size = 80;
        if (args.length > 0) {
            switch (Integer.parseInt(args[0])) {
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
                    break;
            }
        }
        Map map = new Map(size);
        Display display = new Display(map);
        Control control = new Control(map);
        display.setVisible(true);
        control.setVisible(true);
        System.out.println("Map size: " + size);
    }
}
