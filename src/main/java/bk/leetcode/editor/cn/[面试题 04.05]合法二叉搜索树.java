//实现一个函数，检查一棵二叉树是否为二叉搜索树。示例 1: 输入:     2    / \   1   3 输出: true 示例 2: 输入:     5
//    / \   1   4      / \     3   6 输出: false 解释: 输入为: [5,1,4,null,null,3,6]。    
//  根节点的值为 5 ，但是其右子节点值为 4 。 Related Topics 树 深度优先搜索 
// 👍 39 👎 0


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
class Solution {


    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;

        return dfs(root, null, null);
    }

    boolean dfs(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;

        if (low != null && node.val <= low) return false;

        if (high != null && node.val >= high ) return false;

        if (!dfs(node.right, node.val, high)) return false;

        if (!dfs(node.left, low ,node.val)) return false;

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
