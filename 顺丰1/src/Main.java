import java.math.BigInteger;
import java.util.Scanner;


/**
 * @author hjy
 * @create 2018/03/30
 * 我们称一个十进制正整数是幸运数当且仅当它只由数字4和7构成。
 * 现在给出一个正整数n，你需要计算有多少个不大于n的幸运数。
 * 由于答案可能非常大，你只需要输出答案除以109+7后的余数。
 *
 *
 *
 **/
public class Main {

	static boolean lucky(Integer num) {
		char[] arr;
		arr = num.toString().toCharArray();
		for (int j = 0; j < arr.length; j++) {
			if(arr[j]!='4') {
				if (arr[j] != '7') {
					return false;

				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Integer n = sc.nextInt();

		Integer ans = 0;
		for (Integer i = 0; i < n; i++ ) {
			if (lucky(i)) {
				ans++;
			}
		}
		System.out.println(ans);
	}



}
