package com.leetcode_3th.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 示例 2: 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 示例 3: 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。   请注意，你的答案必须是 子串
 * 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 * @author Zealot
 * @date Jul 23, 2019 1:03:43 PM
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		boolean[] exist = new boolean[256];
		int i = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			while (exist[s.charAt(j)]) {
				exist[s.charAt(i)] = false;
				i++;
			}
			exist[s.charAt(j)] = true;
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}

//	"tmmzuxt"
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		String s = "tmmzuxt";
		String s2 = "pwwkew";
		String s3 = "aab";
		String s4 = "dvdf";
		System.out.println(l.lengthOfLongestSubstring(s));
	}
}
