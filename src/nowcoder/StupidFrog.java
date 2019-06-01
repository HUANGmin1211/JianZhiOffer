package nowcoder;

/**
 * 题目一：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 题目二：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * */
public class StupidFrog {
    public int JumpFloor(int target) {

//        return press1(target);
        return press2(target);
    }

    /**
     * 题目二
     * */
    private int press2(int target) {
        if (target == 1)
            return 1;
        else
            return 2 * press2(target-1);
    }

    /**
     * 题目一
     * */
    private int press1(int target) {
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        else
            return press1(target-1) + press1(target-2);
    }

}