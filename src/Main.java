import org.junit.Test;


public class Main {
    public int TreeDepth(TreeNode root) {


        return press(root,0);
    }

    private int press(TreeNode root, int deepth) {
        if (root == null)
            return deepth;

        return Math.max(press(root.left, deepth+1),press(root.right, deepth+1));
    }

    @Test
    public void test(){
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}