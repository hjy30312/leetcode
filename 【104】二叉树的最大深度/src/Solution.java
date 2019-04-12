

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class Solution {

    public int maxDepth1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return 0;
        } else if (root1 != null && root2 != null) {
            int a =  maxDepth1(root1.left, root1.right)+1;
            int b = maxDepth1(root2.left, root2.right)+1;
            return  a > b ? a : b;
        } else if (root1 == null){
            return maxDepth1(root2.left, root2.right)+1;
        } else {
            //root2 == null
            return maxDepth1(root1.left, root1.right)+1;
        }
    }
    public int maxDepth(TreeNode root) {
        if (root != null) {
            return maxDepth1(root.left,root.right)+1;
        }
        return 0;
    }
}
