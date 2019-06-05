package nowcoder;


public class Sum {
    // 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    public int Sum_Solution(int n) {
        return press(n);
    }

    private int press(int n) {
        int sum = n;
        boolean b = (n != 0) && (sum += press(n - 1)) != 0;
        return sum;
    }

    // 不用加减乘除求和
    public int Add(int num1, int num2) {
        int yiHuo = num1 ^ num2;
        int yu = num1 & num2;

        if (yu == 0) {
            return yiHuo;
        } else {
            yu <<= 1;
            return Add(yiHuo, yu);
        }

    }




}
