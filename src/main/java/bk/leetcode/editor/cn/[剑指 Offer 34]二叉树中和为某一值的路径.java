//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
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
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 120 👎 0

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

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return ans;

        dfs(root, new ArrayList<Integer>(), sum);

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
