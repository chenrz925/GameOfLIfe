package GameOfLifeTest;

import GameOfLife.Map;
import org.junit.Assert;
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
        Map map = new Map(10);
        boolean[][] testMatrix = new boolean[][]{
                {false, false, false, false, false, false, false, false, true, true},
                {false, false, false, false, false, false, false, false, false, true},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, true,  true,  true,  true,  true,  false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
        };
        map.setMap(testMatrix);
        try {
            Assert.assertEquals(map.nextStateOfPoint(4, 2), false);
            Assert.assertEquals(map.nextStateOfPoint(3, 5), true);
            Assert.assertEquals(map.nextStateOfPoint(1, 8), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test public void nextStateTest() {
        Map map = new Map(10);
        boolean[][] testMatrix = new boolean[][]{
                {true,  true,  false, true,  false, false, false, false, true,  true},
                {false, false, false, false, false, false, false, false, false, true},
                {false, false, false, false, false, false, false, false, false, true},
                {false, false, false, false, false, false, false, false, false, true},
                {false, false, true,  true,  true,  true,  true,  false, false, true},
                {false, false, false, false, false, false, false, false, false, true},
                {false, false, false, false, false, false, false, false, false, true},
                {false, false, false, false, false, false, false, false, false, true},
                {false, false, false, false, false, false, false, false, false, true},
                {false, false, false, false, false, false, false, false, false, true},
        };
        map.setMap(testMatrix);
        map.nextState();
        try {
            Assert.assertEquals(map.getStateOfPoint(0, 0), false);
            Assert.assertEquals(map.getStateOfPoint(8, 8), true);
            Assert.assertEquals(map.getStateOfPoint(9, 9), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test public void stateOfPointTest() {
        Map map = new Map(20);
        try {
            map.setStateOfPoint(10, 10, true);
            Assert.assertEquals(map.getStateOfPoint(10, 10), true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
