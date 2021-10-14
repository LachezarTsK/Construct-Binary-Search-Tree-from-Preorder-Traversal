
import java.util.Stack;

public class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
      
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> monotoneIncreasingStack = new Stack<>();
        monotoneIncreasingStack.push(root);
        int n = preorder.length;

        for (int i = 1; i < n; i++) {
            TreeNode next = null;

            while (!monotoneIncreasingStack.isEmpty() && preorder[i] > monotoneIncreasingStack.peek().val) {
                next = monotoneIncreasingStack.pop();
            }

            if (next != null) {
                next.right = new TreeNode(preorder[i]);
                monotoneIncreasingStack.push(next.right);
            } else {
                next = monotoneIncreasingStack.peek();
                next.left = new TreeNode(preorder[i]);
                monotoneIncreasingStack.push(next.left);
            }
        }
        return root;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
