//给定一个二叉树，在树的最后一行找到最左边的值。 
//
// 示例 1: 
//
// 
//输入:
//
//    2
//   / \
//  1   3
//
//输出:
//1
// 
//
// 
//
// 示例 2: 
//
// 
//输入:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
//输出:
//7
// 
//
// 
//
// 注意: 您可以假设树（即给定的根节点）不为 NULL。 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 145 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

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
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, 0);
        return res.get(res.size() - 1).get(0);
    }

    void dfs(TreeNode root, int depth) {
        if (root == null)
            return;

        if (res.size() == depth) {
            res.add(depth, new ArrayList<>());
        }
        res.get(depth).add(root.val);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
