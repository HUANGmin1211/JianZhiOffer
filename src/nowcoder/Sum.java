package nowcoder;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum {
    public int Sum_Solution(int n) {
        return press(n);
    }

    private int press(int n) {
        int sum = n;
        boolean b = (n != 0) && (sum += press(n - 1)) != 0;
        return sum;
    }
}
