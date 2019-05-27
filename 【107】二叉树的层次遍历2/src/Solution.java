import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        func(root,0);
        //反转
        Collections.reverse(lists);
        return lists;
    }

    /**
     *
     * @param tree 当前树
     * @param level 树的层数
     */
    public void func(TreeNode tree, int level) {
        if (tree == null) {
            return;
        }
        //第一次访问当前层数  增加新的list
        if (lists.size() <= level) {
            lists.add(new ArrayList<Integer>());
        }
        //自顶向下添加
        lists.get(level).add(tree.val);
        func(tree.left,level+1);
        func(tree.right,level+1);
    }

    public static void main(String[] args) {
//        [3,9,20,null,null,15,7]
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        new Solution().levelOrderBottom(t1);
    }

}
