package nowcoder;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class RebuilderTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 1 && in.length == 1)
            return new TreeNode(pre[0]);

        return press(pre,0,pre.length-1, in, 0, in.length-1);
    }

    private TreeNode press(int[] pre, int pi, int pj, int[] in, int ii, int ij) {

        if (pi == pj)
            return new TreeNode(pre[pi]);

        int rootValue = pre[pi];
        int indexIn = 0;
        for (; indexIn < in.length; indexIn++){
            if (in[indexIn] == rootValue)
                break;
        }

        TreeNode root = new TreeNode(rootValue);
        if (indexIn == ii)
            root.left = null;
        else
            root.left = press(pre, pi+1, pi+indexIn-ii, in, ii, indexIn-1);

        if (indexIn == ij)
            root.right = null;
        else
            root.right = press(pre, pi+indexIn-ii+1, pj, in, indexIn+1, ij);


        return root;
    }
}
