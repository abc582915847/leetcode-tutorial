//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 407 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
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

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return ans;

        dfs(root, new ArrayList<>(), sum);

        return ans;
    }

    void dfs(TreeNode root, List<Integer> path, int sum) {

        if (root == null)
            return;

        path.add(root.val);

        if (root.left == null && root.right == null) {
            if ((sum - root.val) == 0) {
                ans.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }

        dfs(root.left, path, sum - root.val);
        dfs(root.right, path, sum - root.val);

        path.remove(path.size() - 1);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
