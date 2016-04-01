package com.leetCode._2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. if there isn't one, return 0 instead.
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest) 
 * 
 * Example 2:
 * Given nums = [-2, -1, 2, 1], k = 1
 * return 4. (because the subarray [-1, 2] sums to 1 and is the longest)
 * 
 * @author Zealot
 * @date 2016年4月1日 下午4:15:15 
 *
 */
public class MaximumSizeSubarraySumEqualsk {
	public int maxSubArrayLen(int[] nums, int k){
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfs(nums, k, 0, new ArrayList<Integer>(), 0, list);
		if(list.size()>0){
			Collections.sort(list);
			return list.get(list.size() - 1);
		}
		return 0;
	}
	private void dfs(int[] nums, int k, int cur, List<Integer> tmp, int sum, List<Integer> list) {
		if(sum==k){
			list.add(tmp.size());
		}
		for(int i = cur; i < nums.length; i++) {
			tmp.add(nums[i]);
			dfs(nums, k, cur+1, tmp, sum+nums[i], list);
			tmp.remove(tmp.size() - 1);
		}
	}
	public static void main(String[] args) {
		int[] a = {1, -1, 5, -2, 3};
//		int[] a = {-2, -1, 2, 1};
		MaximumSizeSubarraySumEqualsk m = new MaximumSizeSubarraySumEqualsk();
		System.out.println(m.maxSubArrayLen(a, 1));
	}
}
