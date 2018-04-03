/**
 * 给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。
 * 不要另外定义一个数组，您必须通过用 O(1) 额外内存原地修改输入的数组来做到这一点。
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int ans = nums.length;

        for (int i = 1; i < ans; i++) {

            if (nums[i] == nums[i-1]) {
                //如果到最后一位  直接减少数量
                if(i == ans - 1) {
                    ans--;
                    break;
                }
                //从后依次向前移
                for (int j = i; j < ans-1; j++) {
                    nums[j] = nums[j+1];
                }
                //数据数量减一
                ans--;
                //因为还需要判断移位后 原来的位置是否又重复
                i--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,1};
        int ans = new Solution().removeDuplicates(arr);
        for (int i = 0; i < ans; i++) {
            System.out.print(arr[i] + " ");
        }
    }



}