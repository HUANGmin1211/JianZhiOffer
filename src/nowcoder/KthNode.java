package nowcoder;

public class KthNode {
    int index = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0)
            return null;
        return press(pRoot, k);
    }

    private TreeNode press(TreeNode pRoot, int k) {
        if (pRoot.left != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null)
                return node;
        }

        index++;
        if (index == k)
            return pRoot;
        if (pRoot.right != null) {
            TreeNode node = KthNode(pRoot.right, k);
            if (node != null)
                return node;
        }

        return null;
    }
}
