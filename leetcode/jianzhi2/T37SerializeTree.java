package leetcode.jianzhi2;

import leetcode.TreeNode;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2022-12-03
 */
public class T37SerializeTree {

    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<String> trees = new ArrayList<>();
        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            if (node == null) {
                trees.add("null");
                continue;
            }
            trees.add(node.val + "");
            if (node.left != null) {
                queue.add(node.left);
            } else {
                queue.add(null);
            }
            if (node.right != null) {
                queue.add(node.right);
            } else {
                queue.add(null);
            }
        }
        StringJoiner sj = new StringJoiner(",");
        trees.forEach(sj::add);
        return sj.toString();
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<String> dataList = Arrays.asList(data.split(","));
        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        queue.add(root);
        int idx = 1;
        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            if (!"null".equals(dataList.get(idx))) {
                TreeNode left = new TreeNode(Integer.parseInt(dataList.get(idx)));
                node.left = left;
                queue.add(left);
            }
            idx++;
            if (!"null".equals(dataList.get(idx))) {
                TreeNode right = new TreeNode(Integer.parseInt(dataList.get(idx)));
                node.right = right;
                queue.add(right);
            }
            idx++;
        }

        return root;
    }



    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode n1 = new TreeNode(2);
//        TreeNode n2 = new TreeNode(3);
//        root.left = n1;
//        root.right = n2;
//        TreeNode n3 = new TreeNode(4);
//        TreeNode n4 = new TreeNode(5);
//        n2.left = n3;
//        n2.right = n4;

//        TreeNode root = new TreeNode(1);
//        TreeNode n1 = new TreeNode(2);
//        root.left = n1;

        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(1);
        root.left = n1;
        root.right = n2;
        n1.left = n3;

        T37SerializeTree t = new T37SerializeTree();
        String treeString = t.serialize(root);
        System.out.println(treeString);
        TreeNode newRoot = t.deserialize(treeString);
        System.out.println(t.serialize(newRoot));
    }

}
