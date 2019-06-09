import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Main {

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0)
            return 0;

        int[][] path = new int[rows][cols];
        press(0, 0, rows, cols, threshold, path);

        int count = 0;
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                if (path[i][j] == 1)
                    count++;
            }
        }
        return count;
    }

    private void press(int i, int j, int rows, int cols, int threshold, int[][] path) {
        path[i][j] = 1;
        if (i > 0 && canEnter(i - 1, j, threshold) && path[i - 1][j] == 0) {
            path[i - 1][j] = 1;
            press(i - 1, j, rows, cols, threshold, path);
        }
        if (i < rows - 1 && canEnter(i + 1, j, threshold) && path[i + 1][j] == 0) {
            path[i + 1][j] = 1;
            press(i + 1, j, rows, cols, threshold, path);
        }
        if (j > 0 && canEnter(i, j - 1, threshold) && path[i][j - 1] == 0) {
            path[i][j - 1] = 1;
            press(i, j - 1, rows, cols, threshold, path);
        }
        if (j < cols - 1 && canEnter(i, j + 1, threshold) && path[i][j + 1] == 0) {
            path[i][j + 1] = 1;
            press(i, j + 1, rows, cols, threshold, path);
        }
    }

    private boolean canEnter(int i, int j, int threshold) {
        String si = String.valueOf(i);
        String sj = String.valueOf(j);

        int sum = 0;
        for (int m = 0; m < si.length(); m++) {
            sum += Integer.valueOf(si.charAt(m) + "");
        }
        for (int m = 0; m < sj.length(); m++) {
            sum += Integer.valueOf(sj.charAt(m) + "");
        }

        return sum <= threshold;
    }

    @Test
    public void test() {
        System.out.println(movingCount(15, 20, 20));
    }

}