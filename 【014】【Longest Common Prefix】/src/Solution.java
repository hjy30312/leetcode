
/**
 * @author: hjy
 * @description:纵向比较  每次比较数组一个字符
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        //当前数组内字符串的位置
        for (int i = 0; i < strs[0].length(); i++) {
            //控制数组
            for (int j = 1; j < strs.length; j++) {
                //比较位置大于等于当前数组长度 或 比较位置不相等
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}