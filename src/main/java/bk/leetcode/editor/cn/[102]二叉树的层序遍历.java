//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 744 👎 0

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        dfs(root, 0, res);
        return res;
    }

    void dfs(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null)
            return;

        if (depth == res.size()) {
            res.add(depth, new ArrayList<>());
        }
        res.get(depth).add(root.val);
        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
