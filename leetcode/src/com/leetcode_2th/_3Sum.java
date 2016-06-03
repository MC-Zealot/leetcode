package com.leetcode_2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月3日 上午10:33:17 
 *
 */
public class _3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length<=0){
			return res;
		}
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		Set<String> tmpSet = new HashSet<String>();
		for(int i = 0; i < nums.length - 1; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				int tmp = nums[i]+nums[j];
				if(map.containsKey(-tmp) && map.get(-tmp)>j){
					tmpSet.add(nums[i]+"\t"+nums[j]+"\t"+(-tmp));
				}
			}
		}
		for(String s: tmpSet){
			String[] ss = s.split("\t");
			List<Integer> list = new ArrayList<Integer>();
			for(String i:ss){
				list.add(Integer.parseInt(i));
			}
			res.add(list);
		}
		return res;
    }
	public static void main(String[] args) {
		_3Sum s = new _3Sum();
		int[] a = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		System.out.println(s.threeSum(a));
	}
}
