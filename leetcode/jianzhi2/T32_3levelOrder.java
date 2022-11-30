package leetcode.jianzhi2;

import leetcode.TreeNode;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2022-11-30
 */
public class T32_3levelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int deep = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();

            while (size > 0) {
                TreeNode cur = queue.poll();
                tmp.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                size--;
            }
            if (deep % 2 != 0) {
                Collections.reverse(tmp);
            }
            res.add(tmp);
            deep++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
