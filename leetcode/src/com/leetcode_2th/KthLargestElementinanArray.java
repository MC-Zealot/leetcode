package com.leetcode_2th;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, 
 * not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * @author Zealot
 * @date 2016年7月3日 下午10:44:14 
 *
 */
public class KthLargestElementinanArray {
	/**
	 * rumtime complexity: nlogn
	 * @date 2016年7月3日 下午10:47:23
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length-k];
	}
	
	/**
	 * nlogk
	 * @date 2016年7月3日 下午10:58:40
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest2(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
		for (int i = 0; i < nums.length; i++) {
			//小鱼size
			if(queue.size()<k){
				queue.add(nums[i]);
			}else if(queue.size()==k&& queue.peek()< nums[i]){//等于size
				queue.poll();
				queue.add(nums[i]);
			}
			
		}
		return queue.poll();
	}
	public static void main(String[] args) {
		KthLargestElementinanArray k = new KthLargestElementinanArray();
		int[] a = {3,2,1,5,6,4};
		System.out.println(k.findKthLargest2(a, 3));
	}
}
