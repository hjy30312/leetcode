
import java.util.Arrays;

/**
 * @author: hjy
 * @description:给定一个整数数组，找出其中两个数满足相加等于你指定的目标数字,
 *　　    要求：这个函数twoSum必须要返回能够相加等于目标数字的两个数的索引，且index1必须要小于index2。
 *        请注意一点，你返回的结果（包括index1和index2）都不是基于0开始的。
 *        你可以假设每一个输入肯定只有一个结果。
 */
public class Solution {

	private static class Node implements Comparable<Node> {
		int val; //值
		int idx; //数组下标

		public Node() {
		}

		public Node(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}

		//比较方法
		@Override
		public int compareTo(Node o) {
			if (o == null) {
				return -1;
			}
			return this.val - o.val;
		}
	}

	/**
	 *
	 * @param nums   输入数组
	 * @param target  两个数相加的和
	 * @return 两个数对应的下标
	 */
	public int[] twoSum(int[] nums, int target) {
		// 用于保存返回结果
		int[] result = {0, 0};

		// 创建辅助数组
		Node[] tmp = new Node[nums.length];
		for (int i = 0; i < nums.length; i++) {
			tmp[i] = new Node(nums[i],i);
		}

		// 排序
		Arrays.sort(tmp);

		int left = 0;
		int right = nums.length - 1;


		// 两边向中间靠拢求解
		while (left < right) {
			//满足条件
			if (tmp[left].val + tmp[right].val == target) {
				//下标小的放0 大的放1
				if (tmp[left].idx > tmp[right].idx) {
					result[0] = tmp[right].idx;
					result[1] = tmp[left].idx;
				} else {
					result[0] = tmp[left].idx + 1;
					result[1] = tmp[right].idx + 1;
				}
				break;
			} else if (tmp[left].val + tmp[right].val > target) {
				//大于  则右边下标移动
				right--;
			} else {
				//小于， 左边下标移动
				left++;
			}
		}
		return result;
	}
	public static void main(String[] args) {
	    int[] arr = new int[]{3,2,4};
		System.out.println(Arrays.toString(new Solution().twoSum(arr, 6)));
	}

}

