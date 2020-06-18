package 快速排序;

/**
 * 算法改进： 可考虑三取样切分，随机取样
 * @author hjy
 * @create 2018/03/26
 **/
public class Quick {

	public static void sort(int[] arr, int left, int right) {
		if (left < right) {
			// 一趟快排，返回交换后的数组下标
			int position = partition(arr, left, right);
			sort(arr, left, position - 1);
			sort(arr, position + 1, right);
		}
	}

	private static int partition(int[] arr, int left, int right) {
		int position = arr[left];
		int i = left;
		int j = right;
		while (i < j) {
			// 从右往左找第一个小于基数的
			while (i < j && arr[j] >= position) {
				j--;
			}
			// 从右往左找第一个大于基数的
			while (i < j && arr[i] <= position) {
				i++;
			}
			swap(arr, i, j);
		}
		// 先从右往左保证了最后i与基准值交换后一定是正确的（left此时一定是大于基数的）
		swap(arr, left, i);
		return left;
	}


	private static void swap( int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
