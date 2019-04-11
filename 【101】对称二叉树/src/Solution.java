

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */


public class Solution {
    public boolean isSymmetrice1(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.val != r2.val) {
            return false;
        }
        if (isSymmetrice1(r1.left, r2.right) && isSymmetrice1(r1.right, r2.left)) {
            return true;
        }
        return false;
    }
    public boolean isSymmetrice(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetrice1(root.left, root.right);

    }

    public static void main(String[] args) {

        System.out.println(null == null);
    }

}
