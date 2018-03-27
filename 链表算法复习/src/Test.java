/**
 * 蒜头君打了一个哑谜（毕竟年龄是女孩子的隐私）
 * 说：“我的年龄是花椰妹年龄个位数和十位数之和的二倍”
 * @author hjy
 * @create 2018/03/27
 **/
public class Test {


	public static void main(String[] args) {
		int[] arr = new int[1005];
		//初始化
		for (int i = 1; i <= 1000; i++) {
			arr[i] = 1;
		}

		for (int i = 3; i <= 1000; i++) {
			if (i % 3 == 0) {
				if (arr[i] == 1) {
					arr[i] = 0;
				} else {
					arr[i] = 1;
				}
			}
		}

		for (int i = 5; i <= 1000; i++) {
			if (i % 5 == 0) {
				if (arr[i] == 1) {
					arr[i] = 0;
				} else {
					arr[i] = 1;
				}
			}
		}

		for (int i = 7; i <= 1000; i++) {
			if (i % 7 == 0) {
				if (arr[i] == 1) {
					arr[i] = 0;
				} else {
					arr[i] = 1;
				}
			}
		}
		int ans = 0;
		for (int i = 1; i <= 1000; i++) {
			if (arr[i] == 1) {
				ans++;
			}
		}
		System.out.println(ans);
	}


}
