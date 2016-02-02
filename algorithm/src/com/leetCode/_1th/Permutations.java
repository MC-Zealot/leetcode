package com.leetCode._1th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * @author Zealot
 * @date 2015年8月25日 下午9:11:25
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		if (nums.length == 1) {
			List<Integer> li = new ArrayList<Integer>();
			li.add(nums[0]);
			List<List<Integer>> lli = new ArrayList<List<Integer>>();
			lli.add(li);
			return lli;
		} else {
			List<List<Integer>> lli = new ArrayList<List<Integer>>();
			for (int i = 0; i < nums.length; i++) {
				int head = nums[i];
				int[] sub = new int[nums.length - 1];
				for (int j = 0; j < sub.length; j++) {
					if (j < i) {
						sub[j] = nums[j];
					} else {
						sub[j] = nums[j + 1];
					}
				}
				List<List<Integer>> sublist = permute(sub);
				for (List<Integer> e : sublist) {
					e.add(0, head);
				}
				lli.addAll(sublist);
			}
			return lli;
		}
	}
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
//		list.p
//		System.out.println(list.toString());
		list.add(1, "9");
//		System.out.println(list.toString());
		Permutations p = new Permutations();
		int[] nums = {1,2,3};
//		System.out.println(p.permute(nums));
		List<List<Integer>> combs = new ArrayList<>();
		int n = 4;
		for (int i = 1; i <= n; i++) combs.add(Arrays.asList(i));
		System.out.println(combs.toString());
	}
}
