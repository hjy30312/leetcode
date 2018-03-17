import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个罗马数字，将其转换成整数。
 * 返回的结果要求在 1 到 3999 的范围内。
 * @author hjy
 * @create 2018/03/09
 **/
public class Solution {
	static Map<Character, Integer> map = new HashMap<>();
	//初始化字典
	static {
		map.put('I',1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}
	public static int getRomanValue(char c) {
		return map.get(c);
	}

	public int romanToInt(String s) {
		int len = s.length();
		if (len == 0) {
			return 0;
		}
		int sum = 0;
		//不管是左小右大  还是左大右小 最后一位都是加上
		int res = getRomanValue(s.charAt(len-1));

		for (int i = 0; i < len-1; i++) {

			if (getRomanValue(s.charAt(i)) >= getRomanValue(s.charAt(i+1))) {
				//左大右小或相等
				res += getRomanValue(s.charAt(i));
			} else {
				res -= getRomanValue(s.charAt(i));
			}
		}
		return  res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().romanToInt("DCXXI"));
	}
}