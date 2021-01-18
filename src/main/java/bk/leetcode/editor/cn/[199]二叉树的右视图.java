//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 393 👎 0

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
class Solution {

    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return res;

        dfs(root, 0);
        return res;
    }

    void dfs(TreeNode root, int depth) {
        if (root == null)
            return;

        if (res.size() == depth) {
            res.add(depth, 0);
        }
        res.set(depth, root.val);

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
