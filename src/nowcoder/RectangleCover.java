package nowcoder;

import org.junit.Test;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * */
public class RectangleCover {
    public int RectCover(int target) {
        if (target < 1) // 保证程序的健壮性
            return 0;
        return press(target);
    }

    private int press(int target) {
        if (target == 1)
            return 1;
        else if (target == 2)
            return 2;
        else
            return press(target-2) + press(target - 1);
    }

    @Test
    public void test(){
        System.out.println(RectCover(3));
    }
}
