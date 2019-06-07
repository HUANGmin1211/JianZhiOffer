package nowcoder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class SerializeTree {
    String Serialize(TreeNode root) {
        if (root == null)
            return "#_";

        StringBuilder sb = new StringBuilder(root.val + "_");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));

        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        String[] arr = str.split("_");
        LinkedList<String> queue = new LinkedList<>();
        for (String s : arr)
            queue.add(s);

        return press(queue);
    }

    private TreeNode press(LinkedList<String> queue) {
        String s = queue.pollFirst();
        if (s.equals("#"))
            return null;

        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = press(queue);
        root.right = press(queue);
        return root;
    }
}
