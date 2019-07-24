package com.leetcode_3th.string;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 示例 2：
 * 
 * 输入: "cbbd" 输出: "bb"
 * 
 * 
 * @author Zealot
 * @date Jul 24, 2019 12:32:22 PM
 *
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		String res = "";
		if(s==null || s.length()==0) {
			return res;
		}
		int b = 0;
		// 2种情况，中心点是一个，中心点是2个
		//如果中心点是2个，1、如何发现。2、如何判断。3、如何改变
		
		for (int center = 0; center < s.length(); center++) {
			int center_len = 1;
			int index = center + 1;
			while(index < s.length() && s.charAt(center) == s.charAt(index)) {
				center_len++;
				index+=1;
			}
			index--;
			b=1;
			// 开始向旁边扩散，应该是一个while循环
			while (center - b>= 0 && index + b  < s.length()) {
				if (s.charAt(center - b) != s.charAt(index + b)) {
					break;
				}
				b++;
			}
			b--;
			//比较字符串长度
			int size = center_len + b + b;
			if(res.length()< size) {
				char[] tmp = new char[size];
				for(int i = center - b,j = 0; i <= index + b && j < size; i++,j++) {
					tmp[j] = s.charAt(i);
				}
				res = String.valueOf(tmp);
			}
			
		}
		
		return res;
	}
	public static void main(String[] args) {
		String s = "aabcb";
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		System.out.println(l.longestPalindrome(s));
	}
}
