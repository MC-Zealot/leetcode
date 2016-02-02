package com.leetCode._1th;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * @author Zealot
 * @date 2015年7月25日 下午4:38:43
 */
public class MajorityElement_169 {
	public int majorityElement(int[] nums) {
		if(nums.length<3){
			return nums[0];
		}
		int n=0;
		if(nums.length%2==1){
			n=(nums.length+1)/2;
		}else{
			n=nums.length/2;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) == null) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
				if(map.get(nums[i])==n){
					return nums[i];
				}
			}
		}
		return 0;
	}
	public int majorityElement2(int[] nums) {

        int n=0;
		if(nums.length%2==1){
			n=(nums.length+1)/2;
		}else{
			n=nums.length/2;
		}
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums){
            if(map.containsKey(i)){
                int a = map.get(i)+1;
                map.put(i,a);
                if(a==n){
                    return i;
                }
            }else{
                map.put(i,1);
            }
        }
        return nums[0];
    
	}
	public int majorityElement3(int[] nums) {
		Arrays.sort(nums);
		 int size = nums.length;
		return nums[size/2];
	}
	public static void main(String[] args) {
		int[] a = {-1,1,1,1,2,1};
		MajorityElement_169 m = new MajorityElement_169();
		System.out.println(m.majorityElement3(a));
	}
}
