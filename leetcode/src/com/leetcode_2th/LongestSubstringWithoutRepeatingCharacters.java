package com.leetcode_2th;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月3日 上午10:21:32 
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if(s==null){
			return 0;
		}
		int start = 0, cur = 0, max = 0, size = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(; cur < s.length(); cur++) {
			char c = s.charAt(cur);
			if(!map.containsKey(c)){
				map.put(c, cur);
				size++;
			}else {
				int index = map.get(c);
				map.put(c, cur);
				if(index < start){
					size++;
					max = size > max ?  size : max;
					continue;
				}
				start = index + 1;
				size = cur - start + 1;
			}
			max = size > max ?  size : max;
		}
		
		size = cur - start ;
		max = size > max ?  size : max;
		return max;
    }
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(l.lengthOfLongestSubstring("pwwkew"));
	}
}
