package com.hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年7月9日 下午4:11:59 
 *
 */
public class DivisibleSubset {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = in.nextInt();
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(!map.containsKey(nums[i])){
				map.put(nums[i], 1);
			}else{
				map.put(nums[i], map.get(nums[i])+1);
			}
		}
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				int sum = nums[i] + nums[j];//可能溢出啊
				if(sum % k != 0){
					set.add(nums[i]);
					set.add(nums[j]);
				}
			}
		}
		int res = 0;
		for(Integer num: set){
			res = res + map.get(num);
		}
		
		System.out.println(res);
		in.close();
	}
}
