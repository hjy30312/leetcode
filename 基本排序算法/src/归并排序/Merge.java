package 归并排序;

/**
 *
 * 自定向下
 * @author hjy
 * @create 2018/03/26
 **/
public class Merge {
	//原地归并
	public static void merge(int[] arr, int lo, int mid, int hi) {

		int i = lo, j = mid +1;

		//复制等待归并数组 用来进行比较操作
		int[] aux = new int[hi - lo + 1];

		//复制
		for (int k = lo; i <= hi; k++) {
			aux[k] = arr[k];
		}

		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				//左半边用尽
				arr[k] = aux[j++];
			} else if (j > hi) {
				//右半边用尽
				arr[k] = aux[i++];
			} else if (aux[j] < aux[i]) {
				//右半边的当前元素小于左半边的当前元素
				arr[k] = aux[j++];
			} else {
				//左半边的当前元素大于等于右半边的当前元素
				arr[k] = aux[i++];
			}
		}
	}

	//归并所需的辅助数组
	private static int[] aux;

	public static void sort(int[] a, int lo, int hi) {
		//将数组a[lo..hi]排序
		if (hi <= lo) {
			return;
		}
		int mid = lo + (hi - lo)/2;
		//左半边排序
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
}
