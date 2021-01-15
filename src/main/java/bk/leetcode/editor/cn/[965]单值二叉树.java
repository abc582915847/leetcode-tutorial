//如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。 
//
// 只有给定的树是单值二叉树时，才返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[1,1,1,1,1,null,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 输入：[2,2,2,5,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定树的节点数范围是 [1, 100]。 
// 每个节点的值都是整数，范围为 [0, 99] 。 
// 
// Related Topics 树 
// 👍 69 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;

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

    public boolean isUnivalTree(TreeNode root) {

        Set<Integer> res = new HashSet<>();
        if (root == null)
            return false;
        dfs(root, res);
        return res.size() == 1;
    }

    void dfs(TreeNode root, Set<Integer> res) {
        if (root == null)
            return;

        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
