/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 */

public class Solution {
    public int lengthOfLastWord(String s) {
        //代表没有" "
        if (s.indexOf(" ") == -1) {
            return s.length();
        }
        //拆分
        String[] strings = s.split(" ");
        int last = strings.length-1;
        //说明为 " " 情况  没有单词
        if (last < 0) {
            return 0;
        } else {
            return strings[last].length();
        }
    }
    /**
     * 看到的好方法:
     * 先去掉前后空格，然后找到最后一个空格后的单词第一个位置
     */

    public int lengthOfLastWord2(String s) {
        s.trim();
        return s.substring(s.lastIndexOf(" ")+1).length();
    }


    public static void main(String[] args) {
        int ans = new Solution().lengthOfLastWord("as");
        System.out.println(ans);
    }
}
