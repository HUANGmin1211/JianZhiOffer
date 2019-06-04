package nowcoder;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class BalanceTree {
    class IsB{
        int high;
        boolean isB;

        public IsB(int high, boolean isB) {
            this.high = high;
            this.isB = isB;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return pressIsB(root).isB;
    }

    public IsB pressIsB(TreeNode root){
        if (root == null)
            return new IsB(0,true);
        if (root.left == null && root.right == null)
            return new IsB(1,true);

        IsB left = pressIsB(root.left);
        if (!left.isB)
            return new IsB(0,false);

        IsB right = pressIsB(root.right);
        if (!right.isB)
            return new IsB(0,false);

        if (Math.abs(left.high - right.high) > 1)
            return new IsB(0,false);
        else
            return new IsB(Math.max(left.high, right.high) + 1, true);
    }
}
