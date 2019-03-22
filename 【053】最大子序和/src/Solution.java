/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            /**
             *  因为是连续 所以当前值 加上前一个最大连续子数组的和
             *  与当前值进行比较   如：temp值为负 则不加
             *  确保 max 为0-i 最大和的连续子数组
             */
            temp = Math.max(nums[i], nums[i]+temp);
            max = Math.max(max,temp);
        }

    }


}
