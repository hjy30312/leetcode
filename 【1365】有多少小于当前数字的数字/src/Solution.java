/**
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
public class Solution {
    // 法一：暴力
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int i_ans = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i && nums[j] < nums[i]) {
                    i_ans++;
                }
            }
            result[i] = i_ans;
        }
        return result;
    }
    // 法二：前缀和
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] ans = new int[nums.length];
        int[] book = new int[101];
        for (int i = 0; i < nums.length; i++) {
            // 表示出现多少次
            book[nums[i]]++;
        }
        // 计算比book[i]小的有多少个
        for (int i = 1; i < 101; i++) {
            book[i] += book[i-1];
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除book[-1]
            if (nums[i] > 0) {
                // 比他本身小
                ans[i] = book[nums[i] - 1];
            }
        }
        return ans;
    }


}
