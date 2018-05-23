import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * 标题：平方十位数

 由0~9这10个数字不重复、不遗漏，可以组成很多10位数字。
 这其中也有很多恰好是平方数（是某个数的平方）。
 比如：1026753849，就是其中最小的一个平方数。
 请你找出其中最大的一个平方数是多少？

 注意：你需要提交的是一个10位数字，不要填写任何多余内容。
 * @author hjy
 * @create 2018/05/23
 **/
public class Main {
	public static void main(String[] args) {
		BigInteger result;  //平方结果
		final BigInteger TEN = new BigInteger("10");
		String s = "100000";

		BigInteger min = new BigInteger("1");
		for (BigInteger num = new BigInteger(s);num.compareTo(min) >= 0;
			 num = num.subtract(new BigInteger("1"))) {

			result = num.multiply(num);
			String value = result.toString();
			Set set = new HashSet();
			//拆分 存入set(利用HashSet 存储对象不可重复性)
			for (int i = 9; i >= 0; i--) {
				//   result%10
				set.add(result.remainder(TEN));
				//   result/10
				result = result.divide(TEN);
			}
			if (set.size() == 10) {
				System.out.println(value);
				break;
			}
		}

	}
}
