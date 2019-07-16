package com.leetcode_3th.array;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if(nums.length==1) {
			return;
		}
		int left=nums.length-2,right=nums.length-1;
		//找到左边和右边的下标
		
		while(left<right && left>=0) {
			if(nums[left] < nums[right]) {
				int tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
				break;
			}
			left--;
			if(left <0 && right>0) {
				right--;
				left=right-1;
			}
		}
		//给left后边排序
		int start = left+1;
		//如果是字典最后一个
		if(left<0) {
			start=0;
		}
		//排序，从start开始，到最后
		int[] a = new int[nums.length - start];
		for(int i = 0; i < a.length; i++) {
			a[i] = nums[i + start];
		}
		Arrays.sort(a);
		for(int i = 0; i < a.length; i++) {
			nums[i+start] = a[i];
		}
		System.out.println(Arrays.toString(nums));
    }
	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] a = {4,2,0,2,3,2,0};
		np.nextPermutation(a);
		
	}
}
