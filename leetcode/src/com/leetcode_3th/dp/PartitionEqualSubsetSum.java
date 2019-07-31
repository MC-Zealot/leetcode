package com.leetcode_3th.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].
 

示例 2:

输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子集.

 * 
 * @author Zealot
 * @date Jul 31, 2019 10:37:50 AM 
 *
 */
public class PartitionEqualSubsetSum {
	boolean res = false;
	/**
	 * 超时
	 * @date Jul 31, 2019 1:14:36 PM
	 * @param nums
	 * @return
	 */
	public boolean canPartition(int[] nums) {
		dfs(0, nums, new ArrayList<Integer>(), 0, new boolean[nums.length]);
		return res;
	}

	public void dfs(int curr, int[] nums, List<Integer> list1, int sum, boolean[] flags) {
		if(list1.size()>nums.length) {
			return;
		}
		int another_sum=0;
		for(int i = 0;i < nums.length; i++) {
			if(flags[i]==false) {
				another_sum+=nums[i];
			}
		}
		
		if(another_sum==sum) {
			res=true;
			return;
		}
		
		for (int i = curr; i < nums.length; i++) {
			list1.add(nums[i]);
			flags[i] = true;
			dfs(i + 1, nums, list1, sum + nums[i],flags);
			list1.remove(list1.size() - 1);
			flags[i] = false;
		}
	}
	public static void main(String[] args) {
		PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
		int[] a = {1, 2, 3, 5};
		System.out.println(p.canPartition(a));
	}
	
	/**
	 * 思路：一个背包的题目，背包容量为数组中元素和的一半＋１，这样只要看是否有元素可以正好填满背包即可．
	 * 
	 * 但是每个元素只能用一次，所以在尝试放一个元素的时候还要避免他对尝试放其他位置时对自己的影响．
	 * 
	 * 所以在尝试放一个元素到背包的时候需要从容量最大的位置开始，如果（当前位置－当前元素大小）位置可以通过放置之前的元素达到，
	 * 
	 * 则当前位置也可以通过放置当前元素正好达到这个位置．
	 * 
	 * 状态转移方程为：dp[i] = dp[i] || dp[i - nums[k]];
	 * @date Jul 31, 2019 1:37:03 PM
	 * @param nums
	 * @return
	 */
	public boolean canPartition2(int[] nums) {

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if ((sum & 1) == 1)
			return false;
		boolean[] dp = new boolean[sum / 2 + 1];
		dp[0] = true;
		for (int i = 0; i < nums.length; i++) {
			for (int j = sum / 2; j >= nums[i]; j--) {
				dp[j] = dp[j] || dp[j - nums[i]];
			}
		}
		return dp[sum / 2];
	}
}
