package GameOfLife;

/**
 * Created by chenrz925 on 2017/6/3.
 * 下午1:21 Project: GameOfLIfe
 *
 * @author chenrz925
 */
public class Main {
    public static void main(String[] args) {
        Map map = new Map(80);
        Display display = new Display(map);
        Control control = new Control(map);
    }
}
