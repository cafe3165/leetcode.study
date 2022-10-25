package leetcode.jianzhi2;

import leetcode.TreeNode;

import java.util.Arrays;

/**
 * Author:cafe3165
 * Date:2022-10-16
 */
public class T7RebuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int rootVal = preorder[0];

        TreeNode root = new TreeNode(rootVal);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }
        int[] leftIn = Arrays.copyOfRange(inorder, 0, index);
        int[] rightIn = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] leftPre = Arrays.copyOfRange(preorder, 1, leftIn.length + 1);
        int[] rightPre = Arrays.copyOfRange(preorder, 1 + leftPre.length, preorder.length);
        System.out.println(Arrays.toString(leftIn));
        System.out.println(Arrays.toString(rightIn));
        System.out.println(Arrays.toString(leftPre));
        System.out.println(Arrays.toString(rightPre));
        root.left = buildTree(leftPre, leftIn);
        root.right = buildTree(rightPre, rightIn);
        return root;
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};

        T7RebuildTree t = new T7RebuildTree();
        TreeNode node = t.buildTree(preorder, inorder);
        System.out.println(node.val);
    }
}
