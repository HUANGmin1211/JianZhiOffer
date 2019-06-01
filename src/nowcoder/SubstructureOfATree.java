package nowcoder;

import org.junit.Test;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * */
public class SubstructureOfATree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null || root1 == null)
            return false;

        return isSubTree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }




    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root1.val != root2.val)
            return false;



        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }

    @Test
    public void test(){
        TreeNode root1 = new TreeNode(8);
//        root1.right = new TreeNode(7);
        root1.left = new TreeNode(8);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
//        root1.left.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        System.out.println(HasSubtree(root1, root2));
    }
}
