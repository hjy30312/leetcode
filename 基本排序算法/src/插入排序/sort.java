package 插入排序;

/**
 * @author hjy
 * @create 2018/03/26
 **/
public class sort {


	public static void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			//内层循环比较 i 与前边所有元素值，如果 j 索引所指的值小于 j- 1 则交换两者的位置
			for (int j = i; j > 0 && arr[j-1] > arr[j]; j--) {
				int t = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = t;
			}
		}
	}



}
