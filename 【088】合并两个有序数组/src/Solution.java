/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m+n];
        int i = 0, j = 0, ans = 0;
        while(i < m && j <n) {
            if (nums1[i] > nums2[j]) {
                nums3[ans++] = nums2[j++];
            } else {
                nums3[ans++] = nums1[i++];
            }
        }
        while (i < m) {
            nums3[ans++] = nums1[i++];
        }

        while (j < n) {
            nums3[ans++] = nums2[j++];

        }
       System.arraycopy(nums3,0,nums1,0,m+n);
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        new Solution().merge(arr1,3,arr2,3);
        for (int i :
                arr1) {
            System.out.println(i);
        }
    }

}
