//给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 ->
// 0 -> 1，那么它表示二进制数 01101，也就是 13 。 
//
// 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。 
//
// 返回这些数字之和。题目数据保证答案是一个 32 位 整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,0,1,0,1,0,1]
//输出：22
//解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：root = [1,1]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 树中的结点数介于 1 和 1000 之间。 
// Node.val 为 0 或 1 。 
// 
// Related Topics 树 
// 👍 90 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

public class TreeNode {
    int      val;
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

class Solution {

    int ans = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null)
            return 0;

        dfs(root, "");

        return ans;
    }

    void dfs(TreeNode root, String path) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            ans += Integer.parseInt(path + root.val, 2);
            return;
        }

        dfs(root.left, path + root.val);
        dfs(root.right, path + root.val);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
