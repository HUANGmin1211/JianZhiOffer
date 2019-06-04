package nowcoder;

import org.junit.Test;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * */
public class NumberOf1 {

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        int bit = 1;

        while(n >= bit){
            int before = n / (bit * 10);
            int after = n % bit;
            int current = (n - before * bit * 10 - after) / bit;

            if (current < 1){
                count += before * bit;
            }else if (current > 1)
                count += (before + 1) * bit;
            else
                count += before * bit + after + 1;

            bit *= 10;
        }

        return count;
    }

    @Test
    public void test(){
        System.out.println(NumberOf1Between1AndN_Solution(13));
    }
}
