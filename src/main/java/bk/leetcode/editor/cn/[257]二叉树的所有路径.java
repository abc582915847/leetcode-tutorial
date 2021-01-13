//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 424 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.stream.Collectors;

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

    void dfs(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            paths.add(path + root.val);
            return;
        }

        path += root.val;
        dfs(root.left, path + "->", paths);
        dfs(root.right, path + "->", paths);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<String> paths = new ArrayList<>();

        dfs(root, "", paths);

        return paths;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
