package nowcoder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class WindowMaxValue {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        if (size <= 0)
            return list;

        for (int i = 0; i < num.length; i++) {

            if (i == 0)
                queue.add(0);
            else {
                if (queue.size() != 0 && i - queue.getFirst() >= size)
                    queue.removeFirst();

                if (queue.size() != 0 && num[i] >= num[queue.getLast()]) {
                    while (queue.size() != 0 && num[i] >= num[queue.getLast()]) {
                        queue.removeLast();
                    }
                    queue.add(i);

                } else {
                    queue.add(i);
                }
            }

            if (i >= size - 1) {
                list.add(num[queue.getFirst()]);
            }
        }
        return list;
    }

    @Test
    public void test() {
        int[] a = {0, 4, 2, 1};
        ArrayList<Integer> list = maxInWindows(a, 1);
        for (int i : list)
            System.out.println(i);
    }
}
