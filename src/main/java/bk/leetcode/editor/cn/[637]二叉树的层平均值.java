//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 
// 👍 229 👎 0

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
    List<List<Double>> res = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> ret = new ArrayList<>();
        if (root == null)
            return ret;

        dfs(root, 0);

        res.forEach(f -> {
            int size = f.size();
            double sum  = 0;
            for (double i : f) {
                sum += i;
            }
            ret.add(sum / size);
        });

        return ret;
    }

    void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        if (res.size() == depth) {
            res.add(depth, new ArrayList<>());
        }
        res.get(depth).add(root.val * 1.0);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
