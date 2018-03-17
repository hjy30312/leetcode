/**
 * 给定一个范围为 32 位 int 的整数，将其颠倒。
 *
 * 思路  拆分放入数组   颠倒合并
 * @author hjy
 * @create 2018/03/07
 **/
public class Solution {
	public static void main(String[] args) {
		int x = -123;
		System.out.println(new Solution().reverse(x));
	}
	public int reverse(int x) {
		int result = 0;
		long tmp = 0;
		int[] rs = new int[50];
		int i = 0;
		//结束条件
		while (!(x % 10 == 0 && x / 10 == 0)) {
			rs[i++] = x % 10;
			x = x / 10;
		}
		for (int j = 0; j < i; j++) {
			//反转后第一位是0
			if (j == 0 && rs[j] == 0) {
				continue;
			}
			tmp = tmp * 10 + rs[j];
			//判断是否超过范围
			if (tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE) {
				result = 0;
				break;
			}
			result = (int)tmp;
		}
		return result;
	}
}
