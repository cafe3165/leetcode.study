package leetcode.jianzhi2;

import leetcode.TreeNode;

/**
 * Author:cafe3165
 * Date:2022-11-27
 */
public class T26isSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A == null || B == null) {
            return false;
        }
            return isSubStruct(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSubStruct(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return isSubStruct(A.left, B.left) && isSubStruct(A.right, B.right);
    }

}
