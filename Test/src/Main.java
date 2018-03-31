
// The test point 2, 3, 4 run time out.
import java.util.*;


class Box implements Comparable<Box>{
	public double w;
	public double v;

	@Override
	public String toString() {
		return "Box{" +
				"w=" + w +
				", v=" + v +
				'}';
	}

	public Box(double w, double v) {
		this.w = w;
		this.v = v;
	}


	@Override
	public int compareTo(Box o) {
		if (o.w/o.v > this.w/this.v) {
			return 1;
		} else if (o.w/o.v < this.w/this.v) {
			return -1;
		}
		return 0;
	}
}

public class Main {

	public static int[] father = new int[1005];
	public static int[] visit = new int[10000005];



	public static void main(String[] args) {

		//预处理，num[i][j]表示从第i个数到第j个数字所组成的数
		for(int i = 1; i <= n; i++) {
			num[i][i] = sz[i];
			for (int j = i+1; j <= n; j++) {
				num[i][j] = num[i][j-1]*10 + sz[j];
			}
		}

	}

}

