/**
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        char[] str1 = haystack.toCharArray();
        char[] str2 = needle.toCharArray();

        int i = 0,j = 0;
        //needle ==""的情况
        if (str2.length == 0) {
            return 0;
        }

        while (i<str1.length && j<str2.length) {
            if (str1[i] != str2[j]) {
                i = i - j + 1;   //回到最初比较的之后一个点
                j = 0;
            } else {
                i++;
                j++;
            }
            if (j == str2.length) {
                return i - j;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int ans = new Solution().strStr(haystack, needle);
        System.out.println(ans);
    }

}
