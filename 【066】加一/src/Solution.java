/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        digits[i]++;
        //有进位的情况
        if (digits[i] == 10) {
            boolean flag = true;
            while(i>0&&flag) {
               //满十进一
               digits[i] = 0;
               //下一位+1
               i--;
               digits[i]++;
               if (digits[i] != 10) {
                   flag = false;
               }
            }
        }

        int[] ans;
        //结果第一位为10时，需要移动数组
        if (digits[0] == 10) {
            ans = new int[digits.length + 1];
            ans[0] = 1;
            ans[1] = 0;
            for (int j = 1; j < digits.length; j++) {
                ans[j + 1] = digits[j];
            }
            return ans;
        } else {
            return digits;
        }
    }


    public static void main(String[] args) {
        int[] arr = {2,4,9,3,9};
        int[] ans = new Solution().plusOne(arr);
        for (int i :
                ans) {
            System.out.println(i);
        }
    }
}
