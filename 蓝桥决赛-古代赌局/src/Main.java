/**
 * @author hjy
 * @create 2018/05/18
 **/
public class Main {


	public static int judge1(int[] A, int count){
		int ans = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == count) {
				ans++;
			}
		}
		return ans;
	}

	public static boolean judge2(int[] A, int count) {
		int temp = 1;

		for (int i = 0; i < A.length; i++) {
			temp = A[i]*temp;
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] * count == temp/A[i]) {
				return true;
			}
		}
		return false;
	}

	public static void getResult() {
		//庄家赢的钱
		double won = 0;
		for (int i = 1; i <= 500000; i++) {
			int[] A = new int[3];
			for (int j = 0; j < 3; j++) {
				A[j] = (int) ((Math.random() * 6) + 1);
			}
			int x =  (int) ((Math.random() * 6) + 1);
			int ans = judge1(A,x);
			switch (ans) {
				case 1: won-=1; break;
				case 2: won-=2; break;
				case 3: won-=6; break;
				case 0:
					//不是流局
					if (!judge2(A,x)) {
						won+=1;
					}
					break;
				default:
			}
		}
		won /= 500000;
		System.out.printf("%.3f", won);
	}
	public static void main(String[] args) {

		getResult();

	}



}
