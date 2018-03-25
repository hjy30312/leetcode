package 选择排序;

/**
 * @author hjy
 * @create 2018/03/25
 **/
public class sort {

	public static void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int minIndex = i;
			//找到最小的索引
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			//交换
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = arr[i];
		}


	}



}
