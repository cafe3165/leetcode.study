package leetcode.jianzhi2;

import leetcode.TreeNode;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2022-11-23
 */
public class T32levelOrder {


    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> nodeList = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (nodeQueue.size() != 0) {
            TreeNode cur = nodeQueue.poll();
            if (cur.left != null) {
                nodeQueue.add(cur.left);
            }
            if (cur.right != null) {
                nodeQueue.add(cur.right);
            }
            nodeList.add(cur.val);
        }
        return Arrays.stream(nodeList.toArray(nodeList.toArray(new Integer[0]))).mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {

    }
}
