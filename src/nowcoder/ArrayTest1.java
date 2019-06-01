package nowcoder;

import org.junit.Test;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * */
public class ArrayTest1 {
    public void reOrderArray(int [] array) {
        if (array.length == 0 || array.length == 1)
            return;

        int jiIndex = array[0] % 2 == 1 ? 0 : -1; // 奇数边界
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 1 && i != jiIndex){
                while(i != jiIndex + 1){
                    swap(array, i, i-1);
                    i--;
                }
                jiIndex++;
            }
        }
    }

    private void swap(int[] array, int i, int jiIndex) {
        int tmp = array[i];
        array[i] = array[jiIndex];
        array[jiIndex] = tmp;

    }

    @Test
    public void test(){
        int [] a = {1,2,3,4,5,6,7};
        reOrderArray(a);
        for (int i : a)
            System.out.println(i);
    }

}
