package nowcoder;

import org.junit.Test;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * */
public class HouxuBianliArray {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0)
            return false;

        return press(sequence,0,sequence.length-1);
    }

    private boolean press(int[] sequence, int left, int right) {

        if (left == right)
            return true;

        int root = sequence[right];

        int rightTreeLeftBoudry = 0; // 右子树的左边界
        for (; sequence[rightTreeLeftBoudry] < root; rightTreeLeftBoudry++);


        for (int i = rightTreeLeftBoudry; i < right; i++){
            if (sequence[i] < root)
                return false;
        }

        if (rightTreeLeftBoudry == left || rightTreeLeftBoudry == right)
            return press(sequence,left, right-1);
        else
            return press(sequence,left,rightTreeLeftBoudry-1) && press(sequence,rightTreeLeftBoudry,right-1);


    }

    @Test
    public void test(){
        int [] a = {4,8,6,12,16,14,10};
        System.out.println(VerifySquenceOfBST(a));
    }
}
