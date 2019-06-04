package nowcoder;

import org.junit.Test;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * */
public class InversionsInArray {
    public int InversePairs(int [] array) {
        if (array.length == 0)
            return 0;

        return press(array, 0, array.length-1);
    }

    private int press(int[] array, int left, int right) {
        if (left == right)
            return 0;

        int mid = left + ((right-left) >> 1);
        return (press(array, left, mid )+ press(array, mid+1, right) + merge(array, left, mid, right))% 1000000007;

    }

    private int merge(int[] array, int left, int mid, int right) {
        int count = 0;
        int [] help = new int [right - left + 1];
        int indexP = 0;

        int p1 = left;
        int p2 = mid + 1;

        while(p1 <= mid && p2 <= right){
            if (array[p1] <= array[p2]){
                help[indexP++] = array[p1++];
            }else{
                count = (count + mid - p1 + 1)% 1000000007;
                help[indexP++] = array[p2++];
            }

        }
        while (p1 <= mid){
            help[indexP++] = array[p1++];
        }
        while (p2 <= right){
            help[indexP++] = array[p2++];
        }

        for (int i = left; i <= right; i++){
            array[i] = help[i-left];
        }

        return count % 1000000007;



    }

    @Test
    public void test(){
        int [] arr = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(arr));
    }

}
