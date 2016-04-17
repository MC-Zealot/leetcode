package com.leetcode_2th;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年4月17日 下午2:29:31 
 *
 */
public class _1TwoSum {
	/**
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @date 2016年4月17日 下午2:29:37
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if(map.containsKey(target-nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }else{
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
