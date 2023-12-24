package leetcode.jianzhi2;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Author:cafe3165
 * Date:2022-12-01
 */
public class T34pathSum {

    public Stack<TreeNode> stack = new Stack<>();
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {

        dfs(root, target);
        int[] nums = new int[10];

        return res;
    }

    private void dfs(TreeNode node, int num) {

        if (node == null) {
            return;
        }
        stack.push(node);
        num -= node.val;
        if (num == 0 && node.right == null && node.left == null) {
            res.add(stack.stream().map(n -> n.val).collect(Collectors.toList()));
        }
        dfs(node.left, num);
        dfs(node.right, num);
        stack.pop();

    }

    public static void main(String[] args) {

    }

}
