package com.leetcode_3th.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length == 0 || nums == null) {
			return res;
		}
		int[] flags = new int[nums.length];
		Arrays.sort(nums);
		dfs(0, nums, flags, res, new ArrayList<Integer>());

		return res;
	}

	public void dfs(int curr, int[] nums, int[] flags, List<List<Integer>> res, List<Integer> tmp) {
		
		if (nums.length==tmp.size()) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for(int i = 0; i < nums.length; i++) {
			if(flags[i] == 1) {
				continue;
			}
			tmp.add(nums[i]);
			flags[i]=1;
			dfs(++curr, nums,flags,res, tmp);
			flags[i]=0;
			tmp.remove(tmp.size()-1);
		}
		
	}

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
//		list.add(1, "9");
		Permutations p = new Permutations();
		int[] nums = { 1, 2 , 3};
		System.out.println(p.permute(nums));
//		List<List<Integer>> combs = new ArrayList<>();
//		int n = 4;
//		for (int i = 1; i <= n; i++) combs.add(Arrays.asList(i));
//		System.out.println(combs.toString());
	}
}
