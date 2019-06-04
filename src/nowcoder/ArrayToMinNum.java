package nowcoder;

import java.util.*;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * */
public class ArrayToMinNum {

    public String PrintMinNumber(int [] numbers) {

        List<Integer> list = new ArrayList<>();
        for(int i : numbers)
            list.add(i);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer i1 = Integer.valueOf(String.valueOf(o1) + String.valueOf(o2));
                Integer i2 = Integer.valueOf(String.valueOf(o2) + String.valueOf(o1));
                return i1-i2;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i : list)
            sb.append(i);
        return sb.toString();


    }
}
