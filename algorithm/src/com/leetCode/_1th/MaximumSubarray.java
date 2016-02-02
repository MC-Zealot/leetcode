package com.leetCode._1th;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * 
 * @author Zealot
 * @date 2015年7月27日 下午11:12:41
 */
public class MaximumSubarray {
	//O(n3)
	public int maxSubArray(int[] nums) {
		int reVal = 0;
		int tmp = 0;
		for(int i = 0; i < nums.length; i++) {
			for(int j = i; j < nums.length; j++) {
				tmp = 0;
				for(int k = i; k <=j; k++) {
					tmp += nums[k];
					
				}
				if(tmp>reVal){
					reVal=tmp;
				}
			}
		}
		return reVal;
	}
	//O(n2)
	public int maxSubArray2(int[] nums) {
		int reVal = 0;
		int tmp = 0;
		for(int i = 0; i < nums.length; i++) {
			tmp = 0;
			for(int j = i; j < nums.length; j++) {
				tmp += nums[j];
					
				if(tmp>reVal) {
					reVal=tmp;
				}
			}
		}
		return reVal;
	}
	//O(n)
	public int maxSubArray3(int[] nums) {
		int reVal = Integer.MIN_VALUE;
		int tmp = 0;
		for(int i = 0; i < nums.length; i++) {
			if(tmp<0){
				tmp = nums[i];
			}else{
				tmp += nums[i];
			}
				
			if(tmp>reVal){
				reVal=tmp;
			}
		}
		return reVal;
	}
	public static void main(String[] args) {
		MaximumSubarray m = new MaximumSubarray();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//		int[] nums = {-2,-2,-1,2};
		System.out.println(m.maxSubArray3(nums));
	}
}
