//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 119 👎 0

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

    List<Integer> res = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return res;

        dfs(root, 0);

        return res;
    }

    void dfs(TreeNode root, int depth) {
        if (root == null)
            return;

        if (depth == res.size()) {
            res.add(Integer.MIN_VALUE);
        }
        res.set(depth, Math.max(res.get(depth), root.val));
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
