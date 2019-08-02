package com.leetcode_3th.others.heap;

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

 * 
 * @author Zealot
 * @date Aug 2, 2019 12:22:18 PM 
 *
 */
public class KthLargestElementinanArray {
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
	public static void main(String[] args) {
		KthLargestElementinanArray k = new KthLargestElementinanArray();
		int[] nums= {3,2,3,1,2,4,5,5,6};
		System.out.println(k.findKthLargest(nums, 4));
	}
}
