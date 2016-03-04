package com.leetCode._2th;
/**
 * Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * @author Zealot
 * @date 2016年3月4日 上午9:45:34 
 *
 */
public class ImplementstrStr {
	public int strStr(String haystack, String needle) {
		if(haystack.length()<needle.length()){
			return -1;
		}
		for(int i = 0;i < haystack.length() - needle.length() + 1; i++) {
			int index = 0;
			for(int j = i, k = 0; j < haystack.length() && k < needle.length(); j++, k++){
				if(haystack.charAt(j)!=needle.charAt(k)){
					break;
				}
				index++;
			}
			if(index==needle.length()){
				return i;
			}
		}
		return -1;
    }
	public static void main(String[] args) {
		ImplementstrStr i = new ImplementstrStr();
		System.out.println(i.strStr("1", "-1"));
	}
}
