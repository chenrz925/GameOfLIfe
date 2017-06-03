package GameOfLife;

/**
 * Created by chenrz925 on 2017/6/3.
 * 上午10:02 Project: GameOfLIfe
 *
 * @author chenrz925
 */
public class Map {
    int SIZE = 10;
    int sleepTime = 1000;
    Boolean isPause = true;
    Boolean isEmpty = false;

    private boolean[][] map = null;

    public Map(int SIZE) {
        this.SIZE = SIZE;
        map = new boolean[SIZE][SIZE];
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j)
                map[i][j] = false;
        }
    }

    public boolean[][] setMap(boolean[][] map) {
        this.map = map;
        return map;
    }

    boolean[][] getMap() {
        return map;
    }

    public boolean nextStateOfPoint(int x, int y) throws Exception {
        if (x >= SIZE && x < 0 && y >= SIZE && y <= SIZE)
            throw new Exception("Bad query.");
        int aliveCounter = 0;
        for (int i = -1; i < 2; ++i) {
            for (int j = -1; j < 2; ++j) {
                if (i == 0 && j == 0)
                    continue;
                else {
                    if (x + i >= 0 && y + j >= 0 && x + i < SIZE && y + j < SIZE && map[x + i][y + j]) ++aliveCounter;
                }
            }
        }
        if (aliveCounter == 3) return true;
        else if (aliveCounter == 2) return map[x][y];
        else return false;
    }

    public boolean[][] nextState() {
        boolean[][] nextMatrix = new boolean[SIZE][SIZE];
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                try {
                    nextMatrix[i][j] = nextStateOfPoint(i, j);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        map = nextMatrix;
        return map;
    }

    public boolean getStateOfPoint(int x, int y) throws Exception {
        if (x >= SIZE && x < 0 && y >= SIZE && y <= SIZE)
            throw new Exception("Bad query.");
        return map[x][y];
    }

    public boolean setStateOfPoint(int x, int y, boolean state) throws Exception {
        if (x >= SIZE && x < 0 && y >= SIZE && y <= SIZE)
            throw new Exception("Bad query.");
        map[x][y] = state;
        return map[x][y];
    }
}
