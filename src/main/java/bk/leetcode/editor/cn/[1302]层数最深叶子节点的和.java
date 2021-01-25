//给你一棵二叉树，请你返回层数最深的叶子节点的和。 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在 1 到 10^4 之间。 
// 每个节点的值在 1 到 100 之间。 
// 
// Related Topics 树 深度优先搜索 
// 👍 45 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

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
    List<Integer> levels = new ArrayList<>();

    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;

        dfs(root, 0);

        return levels.get(levels.size() - 1);

    }

    void dfs(TreeNode root, int depth) {

        if (root == null)
            return;

        if (levels.size() == depth) {
            levels.add(0);
        }

        if (root.left == null && root.right == null) {
            levels.set(depth, levels.get(depth) + root.val);
            return;
        }
        levels.set(depth, levels.get(depth) + root.val);

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
