/**
 *给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class Solution {

    public String addBinary(String a, String b) {
        String ans = "";
        int sum = 0;
        int lenA = a.length();
        int lenB = b.length();

        while (lenA > 0 || lenB > 0) {
            if (lenA > 0) {
                sum += Integer.parseInt(a.substring(lenA-1, lenA));
                lenA--;
            }
            if (lenB > 0) {
                sum += Integer.parseInt(b.substring(lenB-1, lenB));
                lenB--;
            }
            //计算进位情况
            if (sum == 2) {
                ans = "0" + ans;
                sum = 1;
            }else if (sum == 3) {
                ans = "1" + ans;
                sum = 1;
            } else {
                // 0 或 1
                ans = (sum+"")+ans;
                sum = 0;
            }
        }
        //最高位进位时
        if (sum == 1) {
            ans = "1"+ans;
        }
        return ans;
    }
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(new Solution().addBinary(a, b));


    }
}
