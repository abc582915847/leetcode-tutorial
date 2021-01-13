//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 385 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        dfs(root, 0, result);
        return result;
    }

    void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null)
            return;
        if (level == res.size()) {
            res.add(0, new ArrayList<>());
        }

        dfs(root.left, level + 1, res);
        dfs(root.right, level + 1, res);
        res.get(res.size()-level-1).add(root.val);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
