package 快速排序;

/**
 * 算法改进： 可考虑三取样切分，随机取样
 * @author hjy
 * @create 2018/03/26
 **/
public class Quick {
	public static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(int[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j -1);
		sort(a, j +1, hi);
	}

	private static int partition(int[] a, int lo, int hi) {
		//随机取样法
//		int randomNum = (int) (Math.random() * (r - l + 1) + l);
//		swap(arr, lo, randomNum);


		//将数组切分为a[lo..i1], a[i], a[i+1..hi]
		int i = lo, j = hi +1; //左右扫描指针
		int v = a[lo];

		while (true) {
			//扫描左右,检查扫描是否结束并交换元素
			while (a[++i] < v) if (i == hi) break;

			while (v < a[--j]) if (j == lo) break;

			if (i >= j) break;
			swap(a, i, j);
		}
		swap(a, lo, j);
		return j;
	}
	private static void swap( int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
