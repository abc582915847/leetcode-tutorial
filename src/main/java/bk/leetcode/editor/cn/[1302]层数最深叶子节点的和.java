//给你一棵二叉树，请你返回层数最深的叶子节点的和。 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在 1 到 10^4 之间。 
// 每个节点的值在 1 到 100 之间。 
// 
// Related Topics 树 深度优先搜索 
// 👍 45 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
    List<Integer> ans = new ArrayList<>();

    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;

        bfs(root);

        return ans.get(ans.size() - 1);

    }

    void bfs(TreeNode root) {

        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum  = 0;
            for (int i = 0; i < size; i++) {
                TreeNode nextNode = queue.poll();
                sum += nextNode.val;

                if (nextNode.left != null)
                    queue.add(nextNode.left);
                if (nextNode.right != null)
                    queue.add(nextNode.right);
            }
            ans.add(sum);
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
