/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 */

public class Solution {
    //方法一: 线性处理
    public  int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
    //方法二: 二分处理
    public  int searchInsert2(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        while (low <= high) {
            mid = (low+high)>>1;
            if (nums[mid] > target) {
                high = mid-1;
            } else if (nums[mid] < target) {
                low = mid+1;
            } else {
                return mid;
            }
        }
        return low;

     }

        public static void main(String[] args) {
        int[] nums = {1,3,4,6};
        int ans = new Solution().searchInsert2(nums,2);
        System.out.println(ans);
    }

}
