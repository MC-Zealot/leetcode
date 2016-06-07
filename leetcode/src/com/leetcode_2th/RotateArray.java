package com.leetcode_2th;


/**
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
题目要求，是旋转，想象成一个换，可以旋转大于数组长度次。
 * 
 * @author Zealot
 * @date 2016年6月7日 上午11:21:21 
 *
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
    	k %= nums.length;
	    reverse(nums, 0, nums.length - 1);
	    reverse(nums, 0, k - 1);
	    reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
	    while (start < end) {
	        int temp = nums[start];
	        nums[start] = nums[end];
	        nums[end] = temp;
	        start++;
	        end--;
	    }
	}
    public static void main(String[] args) {
    	RotateArray r = new RotateArray();
    	int[] a ={1,2,3,4,5,6,7};
    	int k = 0;
    	r.rotate(a, k);
	}
}
