package GameOfLifeTest;

import GameOfLife.Map;
import org.junit.Test;

/**
 * Created by chenrz925 on 2017/6/3.
 * 上午11:14 Project: GameOfLIfe
 *
 * @author chenrz925
 */
public class MapTest {
    @Test
    public void nextStateOfPointTest() {
        Map map = new Map(20);
        boolean[][] testMatrix = new boolean[][]{
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, true, true, true, true, true, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
        };

    }
}
