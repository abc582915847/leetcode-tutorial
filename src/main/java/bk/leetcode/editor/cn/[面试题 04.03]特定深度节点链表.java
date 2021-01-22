//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。 
//
// 
//
// 示例： 
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \ 
//      2    3
//     / \    \ 
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
// 
// Related Topics 树 广度优先搜索 
// 👍 31 👎 0


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

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    ListNode[] ans = new ListNode[0];
    List<ListNode> res = new ArrayList<>();

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return ans;

        dfs(tree, 0);
        ans = new ListNode[res.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }

        return ans;

    }

    void dfs(TreeNode root, int depth) {
        if (root == null) return;

        boolean flag = true;
        if (res.size() == depth) {
            res.add(new ListNode(root.val));
            flag = false;
        }

        ListNode cur = res.get(depth);

        while (cur.next != null) {
            cur = cur.next;
        }

        if (flag)
            cur.next = new ListNode(root.val);

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
