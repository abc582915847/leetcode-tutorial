//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 272 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int ans = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        dfs(root);

        return ans;
    }

    void dfs(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            ans += root.left.val;
        }

        dfs(root.left);
        dfs(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
