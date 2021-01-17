//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 56 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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

    List<List<Integer>> res = new ArrayList<>();

    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];

        dfs(root, 0);

        return res.stream().flatMap(Collection::stream).mapToInt(i->i).toArray();

    }

    void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        if (depth == res.size()) {
            res.add(depth, new ArrayList<>());
        }
        res.get(depth).add(root.val);

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
