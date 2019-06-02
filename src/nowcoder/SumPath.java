package nowcoder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * */
public class SumPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        if (root != null)
            press(root, target, listAll, list);
        return listAll;
    }

    private void press(TreeNode root, int target, ArrayList<ArrayList<Integer>> listAll, ArrayList<Integer> list) {

        list.add(root.val);

        if (root.left == null && root.right == null && root.val == target){
            ArrayList<Integer> newList = new ArrayList<>();
            for (int i : list)
                newList.add(i);

            listAll.add(newList);
        }

        if (root.left != null){
            press(root.left, target-root.val, listAll, list);
        }
        if (root.right != null)
            press(root.right, target-root.val, listAll, list);

        list.remove(list.size()-1);

    }

}
