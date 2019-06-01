package nowcoder;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * */
public class MinNumInRotateArray {
    public static int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0 )
            return 0;

        int left = 0;
        int right = array.length-1;

        if (array[left] == array[right]){
            int num = array[left];
            while(array[left] == num)
                left++;
            while (array[right] == num)
                right--;
            left --;
        }

        return getMin(array,left,right);
    }

    private static int getMin(int[] array, int left, int right) {
        if (array[left] < array[right])
            return array[left];

        int mid = 0;
        while(left < right){
            mid = left + ((right-left) >> 1);
            if (array[mid] < array[mid-1])
                break;
            else if (array[mid] > array[array.length-1])
                left = mid+1;
            else
                right = mid;
        }
        return array[mid];
    }

    public static void main(String[] args) {
        int [] arr = {3,5,6,7,7,7,8,10,0,0,2,3,3,3};
        System.out.println(minNumberInRotateArray(arr));
    }
}
